package com.portfolioARGPROG.tb.security.service;

import com.portfolioARGPROG.tb.security.entity.User;
import com.portfolioARGPROG.tb.security.repository.iUsuarioRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<User> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }

    public void save(User usuario) {
        iusuarioRepository.save(usuario);
    }
}
