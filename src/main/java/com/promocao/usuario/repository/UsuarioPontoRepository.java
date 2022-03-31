package com.promocao.usuario.repository;

import com.promocao.usuario.model.entity.UsuarioPontosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioPontoRepository extends JpaRepository<UsuarioPontosEntity, Long> {
    Optional<UsuarioPontosEntity> findByUsuarioId(Long idUsuario);
}
