package com.bebolder.userservice.web.controller;

import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.domain.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController
{
    @Autowired
    private SupervisorService supervisorService;

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @GetMapping("/all")
    public List<SupervisorDTO> getAll(){
        return supervisorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<SupervisorDTO> getSupervisor(@PathVariable("id") long supervisorId) {
        return  supervisorService.getSupervisor(supervisorId);
    }

    @PostMapping("/save")
    public SupervisorDTO save(@RequestBody SupervisorDTO supervisorDTO){
        return supervisorService.save(supervisorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") long supervisorId){
        return  supervisorService.delete(supervisorId);
    }

}
