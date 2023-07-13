package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeCrudRepository extends CrudRepository<Employee,Long> {
}
