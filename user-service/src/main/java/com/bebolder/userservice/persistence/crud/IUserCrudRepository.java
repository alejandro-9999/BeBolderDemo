package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Supervisor;
import com.bebolder.userservice.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
