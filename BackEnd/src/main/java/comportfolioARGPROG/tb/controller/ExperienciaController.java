package comportfolioARGPROG.tb.controller;

import comportfolioARGPROG.tb.models.ExperienciaModel;
import comportfolioARGPROG.tb.services.ExperienciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/experiencia")
    public class ExperienciaController {

        private final ExperienciaService experienciaService;

        public ExperienciaController(ExperienciaService experienciaService) {
            this.experienciaService = experienciaService;
        }

        @PutMapping("/update")
        public ResponseEntity<ExperienciaModel> editarExperiencia(@RequestBody ExperienciaModel experiencia){
            ExperienciaModel updateExperiencia=experienciaService.editarExperiencia(experiencia);
            return new ResponseEntity<>(updateExperiencia, HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<ExperienciaModel>> obtenerExperiencia(){
            List<ExperienciaModel>  experiencias =  experienciaService.buscarExperiencias();
            return new ResponseEntity<>(experiencias, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<ExperienciaModel> crearExperiencia(@RequestBody ExperienciaModel experiencia){
            ExperienciaModel nuevaExperiencia=experienciaService.addExperiencia(experiencia);
            return new ResponseEntity<>(nuevaExperiencia,HttpStatus.CREATED);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id){
            experienciaService.borrarExperiencia(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
