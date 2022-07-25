package com.portfolioARGPROG.tb.security.service;

import com.portfolioARGPROG.tb.security.entity.Rol;
import com.portfolioARGPROG.tb.security.enums.RolNombre;
import com.portfolioARGPROG.tb.security.repository.iRolRepository;

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