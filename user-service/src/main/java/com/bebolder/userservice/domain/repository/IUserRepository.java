package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<UserDTO> getAll();
    Optional<UserDTO> getUser(Long userId);
    UserDTO save(UserDTO userDTO);
    void delete(long userId);
}