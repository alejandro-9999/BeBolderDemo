package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.domain.dto.UserDTO;
import com.bebolder.userservice.domain.repository.ISupervisorRepository;
import com.bebolder.userservice.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {
    @Autowired
    ISupervisorRepository supervisorRepository;

    @Autowired
    private IUserRepository userRepository;

    public List<SupervisorDTO> getAll(){
        return supervisorRepository.getAll();
    }


    public Optional<SupervisorDTO> getSupervisor(long supervisorId){
        return supervisorRepository.getSupervisor(supervisorId);
    }

    public SupervisorDTO save(SupervisorDTO supervisorDTO){
        validateSupervisor(supervisorDTO);
        return supervisorRepository.save(supervisorDTO);
    }

    public Boolean delete(long supervisorId){
        return getSupervisor(supervisorId).map(SupervisorDTO -> {
            supervisorRepository.delete(supervisorId);
            return true;
        }).orElse(false);
    }

    public void validateSupervisor(SupervisorDTO supervisorDTO){
        Optional<UserDTO> supervisor;
        supervisor =  this.userRepository.findByUsername(supervisorDTO.getUsername());
        if(supervisor.isPresent()){
            throw new IllegalArgumentException("The username is already in use");
        }
        supervisor =  this.userRepository.findByEmail(supervisorDTO.getEmail());
        if(supervisor.isPresent()){
            throw new IllegalArgumentException("The email is already in use");
        }
    }

}
