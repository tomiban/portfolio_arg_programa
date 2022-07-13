package comportfolioARGPROG.tb.security.service;

import comportfolioARGPROG.tb.security.entity.Rol;
import comportfolioARGPROG.tb.security.enums.RolNombre;
import comportfolioARGPROG.tb.security.repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        irolRepository.save(rol);
    }
}