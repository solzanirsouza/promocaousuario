package com.promocao.usuario.model.dto;

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
