package com.bebolder.userservice.persistence;

import com.bebolder.userservice.domain.dto.SupervisorDTO;
import com.bebolder.userservice.domain.repository.ISupervisorRepository;
import com.bebolder.userservice.persistence.crud.ISupervisorCrudRepository;
import com.bebolder.userservice.persistence.entity.Supervisor;
import com.bebolder.userservice.persistence.mappers.ISupervisorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupervisorRepository implements ISupervisorRepository {

    @Autowired
    private ISupervisorCrudRepository supervisorCrudRepository;

    @Autowired
    private ISupervisorMapper supervisorMapper;


    @Override
    public List<SupervisorDTO> getAll() {
        List<Supervisor> supervisors = (List<Supervisor>) supervisorCrudRepository.findAll();
        return supervisorMapper.toSupervisorsDTO(supervisors);
    }

    @Override
    public Optional<SupervisorDTO> getSupervisor(long supervisorId) {
        return supervisorCrudRepository.findById(supervisorId).map(supervisor -> supervisorMapper.supervisorToRegularSupervisorDTO(supervisor));
    }

    @Override
    public SupervisorDTO save(SupervisorDTO supervisorDTO) {
        Supervisor supervisor = supervisorMapper.supervisorDTOToSupervisor(supervisorDTO);
        return supervisorMapper.supervisorToRegularSupervisorDTO( supervisorCrudRepository.save(supervisor));
    }

    @Override
    public void delete(long supervisorId) {
        supervisorCrudRepository.findById(supervisorId);
    }

    @Override
    public Optional<SupervisorDTO> findByUsername(String username) {
        return this.supervisorCrudRepository.findByUsername(username).map(supervisor -> this.supervisorMapper.supervisorToRegularSupervisorDTO(supervisor));
    }

    @Override
    public Optional<SupervisorDTO> findByEmail(String email) {
        return this.supervisorCrudRepository.findByEmail(email).map(supervisor -> this.supervisorMapper.supervisorToRegularSupervisorDTO(supervisor));
    }
}
