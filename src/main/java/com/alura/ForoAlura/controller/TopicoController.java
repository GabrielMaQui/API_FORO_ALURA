package com.alura.ForoAlura.controller;

import com.alura.ForoAlura.domain.cursos.Curso;
import com.alura.ForoAlura.domain.cursos.CursoRepositorio;
import com.alura.ForoAlura.domain.topicos.TopicoDTO;
import com.alura.ForoAlura.domain.topicos.TopicoRepositorio;
import com.alura.ForoAlura.domain.topicos.TopicoResponseDTO;
import com.alura.ForoAlura.domain.topicos.TopicoService;
import com.alura.ForoAlura.domain.usuario.Usuario;
import com.alura.ForoAlura.domain.usuario.UsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
