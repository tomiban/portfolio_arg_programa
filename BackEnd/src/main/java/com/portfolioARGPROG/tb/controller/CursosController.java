package com.portfolioARGPROG.tb.controller;

import com.portfolioARGPROG.tb.models.Cursos;
import com.portfolioARGPROG.tb.services.CursosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController {
    private final CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }
    // @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Cursos> editarCurso(@RequestBody Cursos curso){
        Cursos updateCurso=cursosService.editarCurso(curso);
        return new ResponseEntity<>(updateCurso, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cursos>> obtenerCurso(){
        List<Cursos>  cursos =  cursosService.buscarCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Cursos> crearCurso(@RequestBody Cursos curso){
        Cursos nuevoCurso=cursosService.addCurso(curso);
        return new ResponseEntity<>(nuevoCurso,HttpStatus.CREATED);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarCurso(@PathVariable("id") Long id){
        cursosService.borrarCurso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
