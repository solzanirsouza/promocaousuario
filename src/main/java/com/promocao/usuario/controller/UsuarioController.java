package com.promocao.usuario.controller;

import com.promocao.usuario.model.dto.UsuarioRequestDTO;
import com.promocao.usuario.model.dto.UsuarioResponseDTO;
import com.promocao.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/public/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvar(@RequestBody UsuarioRequestDTO usuario) {
        Long idUsuario = service.salvar(usuario);
        return ResponseEntity
                .created(URI.create(format("/api/public/v1/usuario/%d", idUsuario)))
                .body(obterUsuarioResponse(usuario, idUsuario));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponseDTO> obterPorId(@PathVariable("idUsuario") Long idUsuario) {
        UsuarioResponseDTO response = service.obterPorId(idUsuario);
        return ResponseEntity.ok(response);
    }

    private UsuarioResponseDTO obterUsuarioResponse(UsuarioRequestDTO usuario, Long idUsuario) {
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(idUsuario);
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        return response;
    }
}
