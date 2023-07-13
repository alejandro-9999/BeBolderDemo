package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface IRegularUserRepository {
    List<RegularUserDTO> getAll();
    Optional<RegularUserDTO> getRegularUser(Long regularUserId);
    RegularUserDTO save(RegularUserDTO regularUserDTO);
    void delete(long regularUserId);
}
