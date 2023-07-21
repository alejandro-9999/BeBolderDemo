package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.SupervisorDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ISupervisorRepository {
    List<SupervisorDTO> getAll();
    Optional<SupervisorDTO> getSupervisor(long supervisorId);
    SupervisorDTO save(SupervisorDTO supervisorDTO);
    void delete(long supervisorId);
}
