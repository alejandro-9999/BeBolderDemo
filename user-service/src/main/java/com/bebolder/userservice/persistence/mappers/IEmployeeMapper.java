package com.bebolder.userservice.persistence.mappers;


import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.persistence.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IUserMapper.class, ITeamMapper.class})
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);
    @Mapping(source = "id", target = "employeeId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "dateOfEntry", target = "dateOfEntry")
    @Mapping(source = "retirementDate", target = "retirementDate")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);
    List<EmployeeDTO> toEmployeesDTO(List<Employee> employees);

    @Mapping(source = "employeeId", target = "id")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "dateOfEntry", target = "dateOfEntry")
    @Mapping(source = "retirementDate", target = "retirementDate")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

}
