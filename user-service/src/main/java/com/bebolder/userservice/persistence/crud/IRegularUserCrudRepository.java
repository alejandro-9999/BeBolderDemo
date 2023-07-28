package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Admin;
import com.bebolder.userservice.persistence.entity.RegularUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRegularUserCrudRepository extends CrudRepository<RegularUser,Long> {
    Optional<RegularUser> findByUsername(String username);
    Optional<RegularUser> findByEmail(String email);
}
