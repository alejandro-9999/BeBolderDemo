package com.bebolder.userservice.web.controller;

import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.domain.service.EmployeeService;
import com.bebolder.userservice.domain.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private EmployeeService employeeService;

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());


    @GetMapping("/all")
    public List<TeamDTO> getAll(){
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TeamDTO> getTeam(@PathVariable("id") long teamId) {
        return  teamService.getTeam(teamId);
    }

    @PostMapping("/save")
    public TeamDTO save(@RequestBody TeamDTO teamDTO){

        return teamService.save(teamDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") long teamId){
        return  teamService.delete(teamId);
    }

    @PostMapping("/{teamId}/members/{employeeId}")
    public ResponseEntity<TeamDTO> addMember(@PathVariable("teamId") long teamId, @PathVariable("employeeId") long employeeId){
        TeamDTO team = teamService.getTeam(teamId).orElseThrow(() -> new EntityNotFoundException("Team not found with id: " + employeeId));
        EmployeeDTO employee = employeeService.getEmployee(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
        employee.setTeam(team);
        employeeService.save(employee);
        return ResponseEntity.ok().body(teamService.getTeam(team.getTeamId()).orElse(null));
    }

}
