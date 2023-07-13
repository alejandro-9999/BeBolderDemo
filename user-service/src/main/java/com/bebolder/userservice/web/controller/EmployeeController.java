package com.bebolder.userservice.web.controller;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.domain.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeDTO> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeDTO> getEmployee(@PathVariable("id") Long employeeId) {
        return  employeeService.getEmployee(employeeId);
    }

    @PostMapping("/save")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO){

        return employeeService.save(employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long employeeId){
        return  employeeService.delete(employeeId);
    }

}
