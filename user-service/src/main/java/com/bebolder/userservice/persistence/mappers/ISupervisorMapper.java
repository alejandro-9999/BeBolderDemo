package com.bebolder.userservice.persistence.mappers;

import com.bebolder.userservice.domain.dto.RegularUserDTO;
import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.persistence.entity.RegularUser;
import com.bebolder.userservice.persistence.entity.Supervisor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Qualifier;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISupervisorMapper{

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(target = "role", ignore = true)
    })
    SupervisorDTO supervisorToRegularSupervisorDTO(Supervisor supervisor);

    List<SupervisorDTO> toSupervisorsDTO(List<Supervisor> supervisors);

    @Mappings({
            @Mapping(source = "userId", target = "id")
    })
    Supervisor supervisorDTOToSupervisor(SupervisorDTO supervisorDTO);
}
