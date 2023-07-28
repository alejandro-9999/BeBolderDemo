package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Admin;
import com.bebolder.userservice.persistence.entity.Supervisor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ISupervisorCrudRepository extends CrudRepository<Supervisor,Long> {
    Optional<Supervisor> findByUsername(String username);
    Optional<Supervisor> findByEmail(String email);
}
