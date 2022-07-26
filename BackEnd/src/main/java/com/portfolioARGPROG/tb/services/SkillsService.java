package com.portfolioARGPROG.tb.services;


import com.portfolioARGPROG.tb.Repository.SkillsRepo;
import com.portfolioARGPROG.tb.models.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsService {

        private final SkillsRepo skillsRepo;

        @Autowired
        public SkillsService(SkillsRepo skillsRepo) {
            this.skillsRepo = skillsRepo;
        }
        public Skills addSkill(Skills skills ){
            return skillsRepo.save(skills);
        }

        public List<Skills> buscarSkills(){
            return skillsRepo.findAll();
        }
        public Skills editarSkill(Skills skills){
            return skillsRepo.save(skills);
        }

        public void borrarSkill(Long id){
            skillsRepo.deleteById(id);
        }
}
