package com.bebolder.userservice.domain.dto;

import com.bebolder.userservice.persistence.entity.Supervisor;
import com.bebolder.userservice.persistence.entity.Team;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private long employeeId;
    private UserDTO user;
    private String document;
    private String documentType;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Date dateOfEntry;
    private Date retirementDate;
    private String typeOfContract;
    private SupervisorDTO supervisor;
    private TeamDTO team;
}
