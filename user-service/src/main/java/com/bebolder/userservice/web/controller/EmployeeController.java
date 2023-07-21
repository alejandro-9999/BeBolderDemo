package com.bebolder.userservice.web.controller;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.domain.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());


    @GetMapping("/all")
    public List<EmployeeDTO> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeDTO> getEmployee(@PathVariable("id") long employeeId) {
        return  employeeService.getEmployee(employeeId);
    }

    @PostMapping("/save")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO){
        logger.info("Entra aqui");
        logger.info(employeeDTO.toString());
        return employeeService.save(employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") long employeeId){
        return  employeeService.delete(employeeId);
    }

}
