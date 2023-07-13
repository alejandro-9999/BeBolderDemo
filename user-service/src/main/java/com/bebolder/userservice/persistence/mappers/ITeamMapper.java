package com.bebolder.userservice.persistence.mappers;


import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.persistence.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { IEmployeeMapper.class, ISupervisorMapper.class})
public interface ITeamMapper {
    ITeamMapper INSTANCE = Mappers.getMapper(ITeamMapper.class);


    @Mapping(source = "id", target = "teamId")
    @Mapping(source = "members", target = "members")
    @Mapping(source = "supervisor", target = "supervisor")
    TeamDTO teamToTeamDTO(Team team);
    List<TeamDTO> toTeamsDTO(List<Team> teams);

    @Mapping(source = "teamId", target = "id")
    @Mapping(source = "members", target = "members")
    @Mapping(source = "supervisor", target = "supervisor")
    Team teamDTOToTeam(TeamDTO teamDTO);
}
