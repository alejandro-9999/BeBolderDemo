package com.bebolder.userservice.persistence.crud;

import com.bebolder.userservice.persistence.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface ITeamCrudRepository extends CrudRepository<Team,Long> {
}
