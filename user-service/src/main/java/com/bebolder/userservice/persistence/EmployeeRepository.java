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


    private final IEmployeeMapper employeeMapper;
    @Autowired
    public EmployeeRepository(IEmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = (List<Employee>) employeeCrudRepository.findAll();
        return employeeMapper.toArrayDto(employees);
    }

    @Override
    public Optional<EmployeeDTO> getEmployee(long employeeId) {
        return employeeCrudRepository.findById(employeeId).map(employee -> employeeMapper.toDto(employee));
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        return employeeMapper.toDto(employeeCrudRepository.save(employee));
    }

    @Override
    public void delete(long employeeId) {
        employeeCrudRepository.deleteById(employeeId);
    }
}
