package com.bebolder.userservice.web.controller;

import com.bebolder.userservice.domain.dto.AdminDTO;
import com.bebolder.userservice.domain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<AdminDTO> getAll(){
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AdminDTO> getAdmin(@PathVariable("id") Long adminId) {
        return  adminService.getAdmin(adminId);
    }

    @PostMapping("/save")
    public AdminDTO save(@RequestBody AdminDTO adminDTO){
        return adminService.save(adminDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long adminId){
        return  adminService.delete(adminId);
    }

}
