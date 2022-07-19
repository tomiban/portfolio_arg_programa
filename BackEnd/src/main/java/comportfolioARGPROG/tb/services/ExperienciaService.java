package comportfolioARGPROG.tb.services;

import comportfolioARGPROG.tb.Repository.ExperienciaRepo;
import comportfolioARGPROG.tb.models.ExperienciaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



    @Service
    @Transactional
    public class ExperienciaService {
        private final ExperienciaRepo experienciaRepo;

        @Autowired
        public ExperienciaService(ExperienciaRepo experienciaRepo) {
            this.experienciaRepo = experienciaRepo;
        }
        public ExperienciaModel addExperiencia(ExperienciaModel experiencia ){
            return experienciaRepo.save(experiencia);
        }

        public List<ExperienciaModel> buscarExperiencias(){
            return experienciaRepo.findAll();
        }
        public ExperienciaModel editarExperiencia(ExperienciaModel experiencia){
            return experienciaRepo.save(experiencia);
        }

        public void borrarExperiencia(Long id){
            experienciaRepo.deleteById(id);
        }
    }


