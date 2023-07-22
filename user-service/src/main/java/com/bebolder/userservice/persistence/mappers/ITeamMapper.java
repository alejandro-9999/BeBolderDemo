package com.bebolder.userservice.persistence.mappers;


import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.persistence.entity.Employee;
import com.bebolder.userservice.persistence.entity.Team;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IUserMapper.class,ISupervisorMapper.class})
public interface ITeamMapper {

    @Mappings({
            @Mapping(source = "id", target = "employeeId"),
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "dateOfEntry", target = "dateOfEntry"),
            @Mapping(source = "retirementDate", target = "retirementDate"),
            @Mapping(source = "supervisor.id", target = "supervisor.userId"),
            @Mapping(target = "team", ignore = true)
    })
    EmployeeDTO toDto(Employee employee);

    @Mappings({
            @Mapping(source = "id", target = "teamId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "supervisor", target = "supervisor"),
            @Mapping(source = "members", target = "members")
    })
    TeamDTO toDto(Team team);

    List<TeamDTO> toArrayDto(List<Team> teams);

    @InheritInverseConfiguration
    @Mapping(target = "members", ignore = true)
    Team toEntity(TeamDTO teamDTO);
}