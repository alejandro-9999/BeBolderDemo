package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.UserDTO;
import com.bebolder.userservice.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public List<UserDTO> getAll(){
        return userRepository.getAll();
    }

    public Optional<UserDTO> getUser(long userId){
        return userRepository.getUser(userId);
    }

    public UserDTO save(UserDTO UserDTO){
        validateUser(UserDTO);
        return userRepository.save(UserDTO);
    }

    public Boolean delete(long userId){
        return getUser(userId).map(UserDTO -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }

    public void validateUser(UserDTO userDTO){
        Optional<UserDTO> user;
        user =  this.userRepository.findByUsername(userDTO.getUsername());
        if(user.isPresent()){
            throw new IllegalArgumentException("The username is already in use");
        }
        user =  this.userRepository.findByEmail(userDTO.getEmail());
        if(user.isPresent()){
            throw new IllegalArgumentException("The email is already in use");
        }
    }
}
