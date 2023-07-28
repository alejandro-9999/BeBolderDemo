package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.persistence.entity.RegularUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAdminRepository {
    List<AdminDTO> getAll();
    Optional<AdminDTO> getAdmin(long adminId);
    AdminDTO save(AdminDTO adminDTO);
    void delete(long adminId);

    Optional<AdminDTO> findByUsername(String username);
    Optional<AdminDTO> findByEmail(String email);

}
