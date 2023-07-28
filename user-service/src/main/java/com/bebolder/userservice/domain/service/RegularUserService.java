package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.domain.dto.UserDTO;
import com.bebolder.userservice.domain.repository.IRegularUserRepository;
import com.bebolder.userservice.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegularUserService {
    @Autowired
    IRegularUserRepository regularUserRepository;

    @Autowired
    private IUserRepository userRepository;


    public List<RegularUserDTO> getAll(){
        return regularUserRepository.getAll();
    }


    public Optional<RegularUserDTO> getRegularUser(long regularUserId){
        return regularUserRepository.getRegularUser(regularUserId);
    }

    public RegularUserDTO save(RegularUserDTO regularUserDTO){
        validateRegularUser(regularUserDTO);
        return regularUserRepository.save(regularUserDTO);
    }

    public Boolean delete(long regularUserId){
        return getRegularUser(regularUserId).map(regularUserDTO -> {
            regularUserRepository.delete(regularUserId);
            return true;
        }).orElse(false);
    }

    public void validateRegularUser(RegularUserDTO regularUserDTO){
        Optional<UserDTO> regularUser;
        regularUser =  this.userRepository.findByUsername(regularUserDTO.getUsername());
        if(regularUser.isPresent()){
            throw new IllegalArgumentException("The username is already in use");
        }
        regularUser =  this.userRepository.findByEmail(regularUserDTO.getEmail());
        if(regularUser.isPresent()){
            throw new IllegalArgumentException("The email is already in use");
        }
    }
}
