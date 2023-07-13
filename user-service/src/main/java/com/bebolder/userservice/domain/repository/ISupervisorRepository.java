package com.bebolder.userservice.domain.repository;

import com.bebolder.userservice.domain.dto.SupervisorDTO;

import java.util.List;
import java.util.Optional;

public interface ISupervisorRepository {
    List<SupervisorDTO> getAll();
    Optional<SupervisorDTO> getSupervisor(Long supervisorId);
    SupervisorDTO save(SupervisorDTO supervisorDTO);
    void delete(long supervisorId);
}
