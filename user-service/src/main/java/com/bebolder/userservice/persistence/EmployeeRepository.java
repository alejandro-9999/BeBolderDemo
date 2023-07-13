package com.bebolder.userservice.persistence;

import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.domain.repository.IEmployeeRepository;
import com.bebolder.userservice.persistence.crud.IEmployeeCrudRepository;
import com.bebolder.userservice.persistence.entity.Employee;
import com.bebolder.userservice.persistence.mappers.IEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    @Autowired
    private IEmployeeCrudRepository employeeCrudRepository;

    @Autowired
    private IEmployeeMapper employeeMapper;


    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = (List<Employee>) employeeCrudRepository.findAll();
        return employeeMapper.toEmployeesDTO(employees);
    }

    @Override
    public Optional<EmployeeDTO> getEmployee(Long employeeId) {
        return employeeCrudRepository.findById(employeeId).map(employee -> employeeMapper.employeeToEmployeeDTO(employee));
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public void delete(long employeeId) {

    }
}
