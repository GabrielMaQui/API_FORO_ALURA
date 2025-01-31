package com.alura.ForoAlura.domain.topicos;


import com.alura.ForoAlura.domain.cursos.Curso;
import com.alura.ForoAlura.domain.cursos.CursoRepositorio;
import com.alura.ForoAlura.domain.usuario.UserDTO;
import com.alura.ForoAlura.domain.usuario.Usuario;
import com.alura.ForoAlura.domain.usuario.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepositorio topicoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Transactional
    public TopicoResponseDTO crearTopico(TopicoDTO topicoRequestDTO) {
        if (topicoRepositorio.existsByTituloAndMensaje(topicoRequestDTO.titulo(), topicoRequestDTO.mensaje())) {
            throw new IllegalArgumentException("El tópico ya existe con el mismo título y mensaje.");
        }

        Usuario autor = usuarioRepositorio.findById(topicoRequestDTO.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Curso curso = cursoRepositorio.findByNombre(topicoRequestDTO.nombreCurso())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(topicoRequestDTO.titulo());
        topico.setMensaje(topicoRequestDTO.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);
        topico.setFechaCreacion(LocalDateTime.now());

        topico = topicoRepositorio.save(topico);

        return new TopicoResponseDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion()
        );
    }
    public Page<TopicoDTORead> obtenerTodosLosTopicos(Pageable paginacion) {
        return topicoRepositorio.findAll(paginacion)
                .map(topico -> new TopicoDTORead(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion()
                ));
    }

    public TopicoDetalleDTO obtenerDetalleTopico(Long id) {

        Topico topico = topicoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));
        Usuario autor = usuarioRepositorio.findById(topico.getAutor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));



        return new TopicoDetalleDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                new UserDTO(autor.getId(), autor.getNombre(), autor.getEmail()),
                topico.getCurso()
        );
    }

    @Transactional
    public TopicoResponseDTO actualizarTopico(Long id, TopicoActualizaDTO topicoRequestDTO) {
        Topico topico = topicoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));

        if (topicoRepositorio.existsByTituloAndMensaje(topicoRequestDTO.titulo(), topicoRequestDTO.mensaje())) {
            throw new IllegalArgumentException("El tópico ya existe con el mismo título y mensaje.");
        }

        topico.setTitulo(topicoRequestDTO.titulo());
        topico.setMensaje(topicoRequestDTO.mensaje());

        topico = topicoRepositorio.save(topico);

        return new TopicoResponseDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion()
        );
    }

    @Transactional
    public void eliminarTopico(Long id) {
        Topico topico = topicoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));

        topicoRepositorio.delete(topico);
    }
}
