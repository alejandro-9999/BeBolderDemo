package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.domain.repository.ISupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {
    @Autowired
    ISupervisorRepository supervisorRepository;

    public List<SupervisorDTO> getAll(){
        return supervisorRepository.getAll();
    }


    public Optional<SupervisorDTO> getSupervisor(long supervisorId){
        return supervisorRepository.getSupervisor(supervisorId);
    }

    public SupervisorDTO save(SupervisorDTO supervisorDTO){
        return supervisorRepository.save(supervisorDTO);
    }

    public Boolean delete(Long supervisorId){
        return getSupervisor(supervisorId).map(SupervisorDTO -> {
            supervisorRepository.delete(supervisorId);
            return true;
        }).orElse(false);
    }
}
