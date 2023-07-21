package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private IAdminRepository adminRepository;

    public List<AdminDTO> getAll(){
        return adminRepository.getAll();
    }


    public Optional<AdminDTO> getAdmin(long adminId){
        return adminRepository.getAdmin(adminId);
    }

    public AdminDTO save(AdminDTO adminDTO){
        return adminRepository.save(adminDTO);
    }

    public Boolean delete(long adminId){
        return getAdmin(adminId).map(adminDTO -> {
            adminRepository.delete(adminId);
            return true;
        }).orElse(false);
    }

}
