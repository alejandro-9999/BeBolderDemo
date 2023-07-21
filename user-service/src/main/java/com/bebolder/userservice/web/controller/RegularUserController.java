package com.bebolder.userservice.web.controller;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.service.RegularUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regular_user")
public class RegularUserController
{
    @Autowired
    private RegularUserService regularUserService;

    @GetMapping("/all")
    public List<RegularUserDTO> getAll(){
        return regularUserService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<RegularUserDTO> getRegularUser(@PathVariable("id") long regularUserId) {
        return  regularUserService.getRegularUser(regularUserId);
    }

    @PostMapping("/save")
    public RegularUserDTO save(@RequestBody RegularUserDTO supervisorDTO){
        return regularUserService.save(supervisorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") long regularUserId){
        return  regularUserService.delete(regularUserId);
    }

}
