package com.portfolioARGPROG.tb.Repository;

import com.portfolioARGPROG.tb.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario,Long> {
}
