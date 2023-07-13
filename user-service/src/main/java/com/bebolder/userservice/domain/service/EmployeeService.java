package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.domain.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAll(){
        return employeeRepository.getAll();
    }


    public Optional<EmployeeDTO> getEmployee(long employeeId){
        return employeeRepository.getEmployee(employeeId);
    }

    public EmployeeDTO save(EmployeeDTO employeeDTO){
        return employeeRepository.save(employeeDTO);
    }

    public Boolean delete(Long employeeId){
        return getEmployee(employeeId).map(employeeDTO -> {
            employeeRepository.delete(employeeId);
            return true;
        }).orElse(false);
    }
}
