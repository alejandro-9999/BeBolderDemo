package com.bebolder.vacationrequestsservice.domain.service;

import com.bebolder.vacationrequestsservice.domain.dto.VacationRequestDTO;
import com.bebolder.vacationrequestsservice.domain.repository.IVacationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationRequestService{

    @Autowired
    private IVacationRequestRepository vacationRequestRepository;

    public List<VacationRequestDTO> getAll(){
        return vacationRequestRepository.getAll();
    }


    public Optional<VacationRequestDTO> getVacationRequest(long vacationRequestId){
        return vacationRequestRepository.getVacationRequest(vacationRequestId);
    }

    public VacationRequestDTO save(VacationRequestDTO vacationRequestDTO){
        return vacationRequestRepository.save(vacationRequestDTO);
    }

    public Boolean delete(Long vacationRequestId){
        return getVacationRequest(vacationRequestId).map(vacationRequestDTO -> {
            vacationRequestRepository.delete(vacationRequestId);
            return true;
        }).orElse(false);
    }

}
