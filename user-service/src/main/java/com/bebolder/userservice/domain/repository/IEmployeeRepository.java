package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {
    List<EmployeeDTO> getAll();
    Optional<EmployeeDTO> getEmployee(Long employeeId);
    EmployeeDTO save(EmployeeDTO employeeDTO);
    void delete(long employeeId);
}
