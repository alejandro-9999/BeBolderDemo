package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.dto.RegularUserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface IRegularUserRepository {
    List<RegularUserDTO> getAll();
    Optional<RegularUserDTO> getRegularUser(long regularUserId);
    RegularUserDTO save(RegularUserDTO regularUserDTO);
    void delete(long regularUserId);
    Optional<RegularUserDTO> findByUsername(String username);
    Optional<RegularUserDTO> findByEmail(String email);
}
