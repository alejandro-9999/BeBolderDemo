package com.bebolder.vacationrequestsservice.persistence;

import com.bebolder.vacationrequestsservice.domain.dto.VacationRequestDTO;
import com.bebolder.vacationrequestsservice.domain.repository.IVacationRequestRepository;
import com.bebolder.vacationrequestsservice.persistence.crud.IVacationRequestCrudRepository;
import com.bebolder.vacationrequestsservice.persistence.entity.VacationRequest;
import com.bebolder.vacationrequestsservice.persistence.mappers.IVacationRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VacationRequestRepository implements IVacationRequestRepository {
    @Autowired
    private IVacationRequestCrudRepository vacationRequestCrudRepository;

    @Autowired
    private IVacationRequestMapper vacationRequestMapper;

    @Override
    public List<VacationRequestDTO> getAll() {
        List<VacationRequest> vacationRequests = (List<VacationRequest>) vacationRequestCrudRepository.findAll();
        return vacationRequestMapper.toArrayDto(vacationRequests);
    }

    @Override
    public Optional<VacationRequestDTO> getVacationRequest(Long vacationRequestId) {
        return vacationRequestCrudRepository.findById(vacationRequestId).map(vacationRequest -> vacationRequestMapper.toDto(vacationRequest));
    }

    @Override
    public VacationRequestDTO save(VacationRequestDTO vacationRequestDTO) {
        VacationRequest vacationRequest = vacationRequestMapper.toEntity(vacationRequestDTO);
        return vacationRequestMapper.toDto(vacationRequestCrudRepository.save(vacationRequest));
    }

    @Override
    public void delete(long vacationRequestId) {
        vacationRequestCrudRepository.deleteById(vacationRequestId);
    }
}
