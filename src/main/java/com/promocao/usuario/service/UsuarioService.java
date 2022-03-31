package com.promocao.usuario.service;

import com.promocao.usuario.model.Usuario;
import com.promocao.usuario.model.dto.UsuarioResponseDTO;
import com.promocao.usuario.model.entity.UsuarioEntity;
import com.promocao.usuario.model.entity.UsuarioPontosEntity;
import com.promocao.usuario.repository.UsuarioPontoRepository;
import com.promocao.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioPontoRepository pontoRepository;

    public Long salvar(Usuario usuario) {
        UsuarioEntity entity = repository.save(new UsuarioEntity()
                .setNome(usuario.getNome())
                .setEmail(usuario.getEmail()));

        return entity.getId();
    }

    public UsuarioResponseDTO obterPorId(Long idUsuario) {
        Optional<UsuarioEntity> entity = repository.findById(idUsuario);
        return entity
                .map(this::obterUsuarioResponse)
                .orElse(null);
    }

    private UsuarioResponseDTO obterUsuarioResponse(UsuarioEntity entity) {
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setEmail(entity.getEmail());
        response.setPontos(obterPontosUsuario(entity.getId()));
        return response;
    }

    private Long obterPontosUsuario(Long idUsuario) {
        Optional<UsuarioPontosEntity> entity = pontoRepository.findByUsuarioId(idUsuario);
        return entity
                .map(UsuarioPontosEntity::getPontos)
                .orElse(0L);
    }
}
