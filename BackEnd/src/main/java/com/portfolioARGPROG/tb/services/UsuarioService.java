package com.portfolioARGPROG.tb.services;

import com.portfolioARGPROG.tb.models.Usuario;
import com.portfolioARGPROG.tb.exception.UserNotFoundException;
import com.portfolioARGPROG.tb.Repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }


    public Usuario addUser(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> buscarUsuario() {
    return usuarioRepo.findAll();
    }
    public Usuario editarUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }

    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElseThrow(() ->new UserNotFoundException("usuario no encontrado"));
    }
}
