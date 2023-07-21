package com.bebolder.userservice.persistence;

import com.bebolder.userservice.domain.dto.EmployeeDTO;
import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.domain.repository.ITeamRepository;
import com.bebolder.userservice.persistence.crud.ITeamCrudRepository;
import com.bebolder.userservice.persistence.entity.Team;
import com.bebolder.userservice.persistence.mappers.ITeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository implements ITeamRepository {
    @Autowired
    private ITeamCrudRepository teamCrudRepository;

    @Autowired
    private ITeamMapper teamMapper;

    @Override
    public List<TeamDTO> getAll() {
        List<Team> teams = (List<Team>) teamCrudRepository.findAll();
        return teamMapper.toArrayDto(teams);
    }

    @Override
    public Optional<TeamDTO> getTeam(long teamId) {
        return  teamCrudRepository.findById(teamId).map(team -> teamMapper.toDto(team));
    }

    @Override
    public TeamDTO save(TeamDTO teamDTO) {
        Team team = teamMapper.toEntity(teamDTO);
        return teamMapper.toDto(teamCrudRepository.save(team));
    }

    @Override
    public void delete(long teamId) {
        teamCrudRepository.deleteById(teamId);
    }
}
