package com.promocao.usuario.model.dto;

import com.promocao.usuario.model.Usuario;

public class UsuarioResponseDTO extends Usuario {

    private Long id;
    private Long pontos;

    public Long getId() {
        return id;
    }

    public UsuarioResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getPontos() {
        return pontos;
    }

    public UsuarioResponseDTO setPontos(Long pontos) {
        this.pontos = pontos;
        return this;
    }
}
