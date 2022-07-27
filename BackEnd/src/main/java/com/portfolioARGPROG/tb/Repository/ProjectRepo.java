package com.portfolioARGPROG.tb.Repository;

import com.portfolioARGPROG.tb.models.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Proyectos, Long> {
}
