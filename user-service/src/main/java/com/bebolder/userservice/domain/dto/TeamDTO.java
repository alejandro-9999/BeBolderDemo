package com.bebolder.userservice.domain.dto;

import com.bebolder.userservice.persistence.entity.Employee;
import com.bebolder.userservice.persistence.entity.Supervisor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TeamDTO {

    protected long teamId;
    private List<Employee> members;
    private Supervisor supervisor;
}
