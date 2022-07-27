package com.portfolioARGPROG.tb.controller;

import com.portfolioARGPROG.tb.models.Proyectos;
import com.portfolioARGPROG.tb.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectosController {
    private final ProjectService projectService;

    public ProyectosController(ProjectService projectService) {this.projectService = projectService;}

    @PutMapping("/update")
    public ResponseEntity<Proyectos> editarProyecto(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos = projectService.editarProyecto(proyectos);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Proyectos>> obtenerProyectos(){
        List<Proyectos>  proyectos =  projectService.buscarProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Proyectos> crearProyecto(@RequestBody Proyectos proyecto){
        Proyectos nuevoProyecto=projectService.addProyecto(proyecto);
        return new ResponseEntity<>(nuevoProyecto,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable("id") Long id){
        projectService.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
