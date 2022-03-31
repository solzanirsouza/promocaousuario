package com.promocao.usuario.service;

import com.promocao.usuario.model.Usuario;
import com.promocao.usuario.model.dto.UsuarioResponseDTO;
import com.promocao.usuario.model.entity.UsuarioEntity;
import com.promocao.usuario.model.entity.UsuarioPontosEntity;
import com.promocao.usuario.repository.UsuarioPontoRepository;
import com.promocao.usuario.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
public class UsuarioService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioPontoRepository pontoRepository;

    public Long salvar(Usuario usuario) {
        logger.info(format("Salvando usuario %s", usuario.getNome()));
        UsuarioEntity entity = repository.save(new UsuarioEntity()
                .setNome(usuario.getNome())
                .setEmail(usuario.getEmail()));

        return entity.getId();
    }

    public UsuarioResponseDTO obterPorId(Long usuarioId) {
        logger.info(format("Obtendo usuario com id %d", usuarioId));
        Optional<UsuarioEntity> entity = repository.findById(usuarioId);
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
