package com.alura.ForoAlura.controller;

import com.alura.ForoAlura.domain.cursos.Curso;
import com.alura.ForoAlura.domain.cursos.CursoRepositorio;
import com.alura.ForoAlura.domain.topicos.*;
import com.alura.ForoAlura.domain.usuario.Usuario;
import com.alura.ForoAlura.domain.usuario.UsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoResponseDTO> registrarTopico(@RequestBody @Valid TopicoDTO topicoRequestDTO) {
        TopicoResponseDTO nuevoTopico = topicoService.crearTopico(topicoRequestDTO);
        return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoDTORead>> listadoMedicos(@PageableDefault(size = 5) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoService.obtenerTodosLosTopicos(paginacion));
    }

}
