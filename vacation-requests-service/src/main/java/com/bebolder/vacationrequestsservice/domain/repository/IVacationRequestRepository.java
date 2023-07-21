package com.bebolder.vacationrequestsservice.domain.repository;


import com.bebolder.vacationrequestsservice.domain.dto.VacationRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVacationRequestRepository {
    List<VacationRequestDTO> getAll();
    Optional<VacationRequestDTO> getVacationRequest(Long vacationRequestId);
    VacationRequestDTO save(VacationRequestDTO vacationRequestDTO);
    void delete(long vacationRequestId);
}
