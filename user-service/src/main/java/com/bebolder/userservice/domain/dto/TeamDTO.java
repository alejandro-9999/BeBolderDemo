package com.bebolder.userservice.domain.dto;

import com.bebolder.userservice.persistence.entity.Employee;
import com.bebolder.userservice.persistence.entity.Supervisor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TeamDTO {
    private long teamId;
    private String name;
    private List<EmployeeDTO> members;
    private SupervisorDTO supervisor;

    public TeamDTO(long teamId) {
        this.teamId = teamId;
    }

    public TeamDTO(String name, SupervisorDTO supervisor) {
        this.name = name;
        this.supervisor = supervisor;
    }
}
