package com.promocao.usuario.service;

import com.promocao.usuario.model.Usuario;
import com.promocao.usuario.model.dto.UsuarioResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public Long salvar(Usuario usuario) {
        return 1L;
    }

    public UsuarioResponseDTO obterPorId(Long idUsuario){
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(idUsuario);
        return response;
    }
}
