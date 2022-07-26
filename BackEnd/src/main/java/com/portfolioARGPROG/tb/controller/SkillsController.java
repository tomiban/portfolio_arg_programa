package com.portfolioARGPROG.tb.controller;


import com.portfolioARGPROG.tb.models.Skills;
import com.portfolioARGPROG.tb.services.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/skills")
    public class SkillsController {
        private final SkillsService skillsService;

        public SkillsController(SkillsService skillsService) {
            this.skillsService =skillsService;
        }
        // @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/update")
        public ResponseEntity<Skills> editarSkill(@RequestBody Skills skill){
            Skills updateSkill=skillsService.editarSkill(skill);
            return new ResponseEntity<>(updateSkill, HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<Skills>> obtenerSkills(){
            List<Skills>  skills =  skillsService.buscarSkills();
            return new ResponseEntity<>(skills, HttpStatus.OK);
        }
        // @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/add")
        public ResponseEntity<Skills> crearSkills(@RequestBody Skills skill){
            Skills nuevaSkill=skillsService.addSkill(skill);
            return new ResponseEntity<>(nuevaSkill,HttpStatus.CREATED);
        }
        //@PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> borrarSkill(@PathVariable("id") Long id){
            skillsService.borrarSkill(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
