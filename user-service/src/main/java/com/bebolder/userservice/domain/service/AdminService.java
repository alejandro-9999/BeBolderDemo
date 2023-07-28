package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.dto.UserDTO;
import com.bebolder.userservice.domain.repository.IAdminRepository;
import com.bebolder.userservice.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService{
    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private IUserRepository userRepository;

    public List<AdminDTO> getAll(){
        return adminRepository.getAll();
    }


    public Optional<AdminDTO> getAdmin(long adminId){
        return adminRepository.getAdmin(adminId);
    }

    public AdminDTO save(AdminDTO adminDTO){
        validateAdmin(adminDTO);
        return adminRepository.save(adminDTO);
    }

    public Boolean delete(long adminId){
        return getAdmin(adminId).map(adminDTO -> {
            adminRepository.delete(adminId);
            return true;
        }).orElse(false);
    }

    public void validateAdmin(AdminDTO adminDTO){
        Optional<UserDTO> admin;
        admin =  this.userRepository.findByUsername(adminDTO.getUsername());
        if(admin.isPresent()){
            throw new IllegalArgumentException("The username is already in use");
        }
        admin =  this.userRepository.findByEmail(adminDTO.getEmail());
        if(admin.isPresent()){
            throw new IllegalArgumentException("The email is already in use");
        }
    }
}
