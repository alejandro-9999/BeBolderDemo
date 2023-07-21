package com.bebolder.userservice.persistence.mappers;


import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.persistence.entity.Team;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IEmployeeMapper.class,ISupervisorMapper.class})
public interface ITeamMapper {



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