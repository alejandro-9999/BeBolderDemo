package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.domain.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface IUserRepository {
    List<UserDTO> getAll();
    Optional<UserDTO> getUser(long userId);
    UserDTO save(UserDTO userDTO);
    void delete(long userId);
    Optional<UserDTO> findByUsername(String username);
    Optional<UserDTO> findByEmail(String email);

}
