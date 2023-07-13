package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.repository.IRegularUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegularUserService {
    @Autowired
    IRegularUserRepository regularUserRepository;

    public List<RegularUserDTO> getAll(){
        return regularUserRepository.getAll();
    }


    public Optional<RegularUserDTO> getRegularUser(long regularUserId){
        return regularUserRepository.getRegularUser(regularUserId);
    }

    public RegularUserDTO save(RegularUserDTO regularUserDTO){
        return regularUserRepository.save(regularUserDTO);
    }

    public Boolean delete(Long regularUserId){
        return getRegularUser(regularUserId).map(regularUserDTO -> {
            regularUserRepository.delete(regularUserId);
            return true;
        }).orElse(false);
    }
}
