package com.portfolioARGPROG.tb.services;

import com.portfolioARGPROG.tb.Repository.ProjectRepo;
import com.portfolioARGPROG.tb.models.Proyectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }
    public Proyectos addProyecto(Proyectos proyecto ){
        return projectRepo.save(proyecto);
    }

    public List<Proyectos> buscarProyectos(){
        return projectRepo.findAll();
    }
    public Proyectos editarProyecto(Proyectos proyecto){
        return projectRepo.save(proyecto);
    }

    public void borrarProyecto(Long id){
        projectRepo.deleteById(id);
    }
}
