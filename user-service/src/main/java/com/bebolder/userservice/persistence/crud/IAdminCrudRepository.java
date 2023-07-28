package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAdminCrudRepository extends CrudRepository<Admin,Long> {
     Optional<Admin> findByUsername(String username);
     Optional<Admin> findByEmail(String email);
}
