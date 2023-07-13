package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Supervisor;
import org.springframework.data.repository.CrudRepository;

public interface ISupervisorCrudRepository extends CrudRepository<Supervisor,Long> {
}
