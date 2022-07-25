package com.portfolioARGPROG.tb.security.repository;

import com.portfolioARGPROG.tb.security.entity.Rol;
import com.portfolioARGPROG.tb.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}