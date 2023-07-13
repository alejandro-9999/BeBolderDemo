package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.domain.dto.TeamDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ITeamRepository {
    List<TeamDTO> getAll();
    Optional<TeamDTO> getTeam(Long teamId);
    TeamDTO save(TeamDTO teamDTO);
    void delete(long teamId);
}
