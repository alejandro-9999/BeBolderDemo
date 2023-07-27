package com.bebolder.vacationrequestsservice.web.controller;

import com.bebolder.vacationrequestsservice.domain.dto.VacationRequestDTO;
import com.bebolder.vacationrequestsservice.domain.service.VacationRequestService;
import com.bebolder.vacationrequestsservice.persistence.VacationRequestRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/vacation_requests")
public class VacationRequestController {

    @Autowired
    private VacationRequestService vacationRequestService;

    private static final Logger logger = Logger.getLogger(VacationRequestController.class.getName());

    @GetMapping("/all")
    public List<VacationRequestDTO> getAll(){
        return vacationRequestService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<VacationRequestDTO> getVacationRequest(@PathVariable("id") Long vacationRequestId) {
        return  vacationRequestService.getVacationRequest(vacationRequestId);
    }

    @PostMapping("/save")
    public VacationRequestDTO save(@RequestBody VacationRequestDTO vacationRequestDTO){
        return vacationRequestService.save(vacationRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long vacationRequestId){
        return  vacationRequestService.delete(vacationRequestId);
    }
}
