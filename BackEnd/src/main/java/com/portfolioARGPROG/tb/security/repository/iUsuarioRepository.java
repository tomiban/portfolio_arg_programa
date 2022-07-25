package com.portfolioARGPROG.tb.security.repository;


import java.util.Optional;

import com.portfolioARGPROG.tb.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
