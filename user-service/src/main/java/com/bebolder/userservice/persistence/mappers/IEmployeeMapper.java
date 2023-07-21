package com.bebolder.userservice.persistence.mappers;


import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.persistence.entity.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IUserMapper.class, ITeamMapper.class, ISupervisorMapper.class})
public interface IEmployeeMapper {

    @Mapping(source = "id", target = "employeeId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "dateOfEntry", target = "dateOfEntry")
    @Mapping(source = "retirementDate", target = "retirementDate")
    @Mapping(source = "supervisor.id", target = "supervisor.userId")
    @Mapping(target = "team", ignore = true)
    EmployeeDTO toDto(Employee employee);

    List<EmployeeDTO> toArrayDto(List<Employee> employees);

    @InheritInverseConfiguration
    @Mapping(source="team.teamId",target = "team.id")
    Employee toEntity(EmployeeDTO employeeDTO);
}
