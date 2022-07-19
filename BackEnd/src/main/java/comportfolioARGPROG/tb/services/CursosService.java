package comportfolioARGPROG.tb.services;

import comportfolioARGPROG.tb.Repository.CursosRepo;
import comportfolioARGPROG.tb.models.Cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CursosService {
    private final CursosRepo cursosRepo;

    @Autowired
    public CursosService(CursosRepo cursosRepo) {
        this.cursosRepo = cursosRepo;
    }
    public Cursos addCurso(Cursos curso ){
        return cursosRepo.save(curso);
    }

    public List<Cursos> buscarCursos(){
        return cursosRepo.findAll();
    }
    public Cursos editarCurso(Cursos curso){
        return cursosRepo.save(curso);
    }

    public void borrarCurso(Long id){
        cursosRepo.deleteById(id);
    }
}
