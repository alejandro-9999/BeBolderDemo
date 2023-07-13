package com.bebolder.userservice.web.controller;

import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.domain.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/all")
    public List<TeamDTO> getAll(){
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TeamDTO> getTeam(@PathVariable("id") Long teamId) {
        return  teamService.getTeam(teamId);
    }

    @PostMapping("/save")
    public TeamDTO save(@RequestBody TeamDTO teamDTO){
        return teamService.save(teamDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long teamId){
        return  teamService.delete(teamId);
    }
}
