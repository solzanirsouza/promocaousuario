package com.promocao.usuario.model.dto;

import com.promocao.usuario.model.Usuario;

public class UsuarioResponseDTO extends Usuario {

    private Long id;

    public Long getId() {
        return id;
    }

    public UsuarioResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
