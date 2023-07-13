package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface IAdminCrudRepository extends CrudRepository<Admin,Long> {
}
