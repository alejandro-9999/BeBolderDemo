package com.bebolder.userservice.domain.service;

import com.bebolder.userservice.domain.dto.TeamDTO;
import com.bebolder.userservice.domain.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    ITeamRepository teamRepository;

    public List<TeamDTO> getAll(){
        return teamRepository.getAll();
    }


    public Optional<TeamDTO> getTeam(long teamId){
        return teamRepository.getTeam(teamId);
    }

    public TeamDTO save(TeamDTO TeamDTO){
        return teamRepository.save(TeamDTO);
    }

    public Boolean delete(Long teamId){
        return getTeam(teamId).map(TeamDTO -> {
            teamRepository.delete(teamId);
            return true;
        }).orElse(false);
    }
}
