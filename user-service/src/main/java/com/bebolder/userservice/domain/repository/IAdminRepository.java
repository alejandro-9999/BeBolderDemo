package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.AdminDTO;

import java.util.List;
import java.util.Optional;

public interface IAdminRepository {
    List<AdminDTO> getAll();
    Optional<AdminDTO> getAdmin(Long adminId);
    AdminDTO save(AdminDTO adminDTO);
    void delete(long adminId);
}
