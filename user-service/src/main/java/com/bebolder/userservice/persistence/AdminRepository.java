package com.bebolder.userservice.persistence;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.repository.IAdminRepository;
import com.bebolder.userservice.persistence.crud.IAdminCrudRepository;
import com.bebolder.userservice.persistence.entity.Admin;
import com.bebolder.userservice.persistence.mappers.IAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository implements IAdminRepository {
    @Autowired
    private IAdminCrudRepository adminCrudRepository;

    @Autowired
    private IAdminMapper adminMapper;

    public List<AdminDTO> getAll(){
        List<Admin> admins = (List<Admin>) adminCrudRepository.findAll();
        return adminMapper.toAdminsDTO(admins);
    }

    @Override
    public Optional<AdminDTO> getAdmin(long adminId) {
        return adminCrudRepository.findById(adminId).map(admin -> adminMapper.adminToAdminDTO(admin));
    }

    @Override
    public AdminDTO save(AdminDTO adminDTO) {
        Admin admin = adminMapper.adminDTOToAdmin(adminDTO);
        return adminMapper.adminToAdminDTO(adminCrudRepository.save(admin));
    }

    @Override
    public void delete(long adminId) {
        adminCrudRepository.deleteById(adminId);
    }

    @Override
    public Optional<AdminDTO> findByUsername(String username) {
        return this.adminCrudRepository.findByUsername(username).map(admin -> adminMapper.adminToAdminDTO(admin));
    }

    @Override
    public Optional<AdminDTO> findByEmail(String email) {
        return this.adminCrudRepository.findByEmail(email).map(admin -> adminMapper.adminToAdminDTO(admin));
    }
}

