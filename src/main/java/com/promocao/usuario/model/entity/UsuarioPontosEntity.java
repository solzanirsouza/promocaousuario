package com.promocao.usuario.model.entity;

import javax.persistence.*;

@Entity(name = "usuariopontos")
public class UsuarioPontosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuarioid")
    private Long usuarioId;
    private Long pontos;

    public Long getId() {
        return id;
    }

    public UsuarioPontosEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public UsuarioPontosEntity setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public Long getPontos() {
        return pontos;
    }

    public UsuarioPontosEntity setPontos(Long pontos) {
        this.pontos = pontos;
        return this;
    }
}
