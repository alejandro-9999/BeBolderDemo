package com.bebolder.vacationrequestsservice.domain.service;

import com.bebolder.vacationrequestsservice.domain.dto.VacationRequestDTO;
import com.bebolder.vacationrequestsservice.domain.repository.IVacationRequestRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class VacationRequestService {

    @Autowired
    private IVacationRequestRepository vacationRequestRepository;

    private static final Logger logger = Logger.getLogger(VacationRequestService.class.getName());

    private static final String USER_SERVICE_BASE_URL = "http://127.0.0.1:8080";

    private final RestTemplate restTemplate;

    public VacationRequestService() {
        this.restTemplate = new RestTemplate();
    }

    // Constructor utilizado para pruebas, donde se puede pasar un RestTemplate mockeado.
    public VacationRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VacationRequestDTO> getAll() {
        return vacationRequestRepository.getAll();
    }

    public Optional<VacationRequestDTO> getVacationRequest(long vacationRequestId) {
        return vacationRequestRepository.getVacationRequest(vacationRequestId);
    }

    public VacationRequestDTO save(VacationRequestDTO vacationRequestDTO) {
        validateVacationRequest(vacationRequestDTO);
        return vacationRequestRepository.save(vacationRequestDTO);
    }

    public Boolean delete(Long vacationRequestId) {
        return getVacationRequest(vacationRequestId).map(vacationRequestDTO -> {
            vacationRequestRepository.delete(vacationRequestId);
            return true;
        }).orElse(false);
    }

    public void validateVacationRequest(VacationRequestDTO vacationRequestDTO) {
        long employeeId = vacationRequestDTO.getEmployeeId();

        if (employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        Map<String, Object> employee = getEmployee(employeeId);
        logger.info(vacationRequestDTO.toString());

        if (employee == null) {
            throw new IllegalArgumentException(String.format("Employee %d not found.", employeeId));
        }



        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        Date dateOfEntry = null;

        try {
            dateOfEntry = formatter.parse((String) employee.get("dateOfEntry"));
        } catch (ParseException e) {
            throw new IllegalArgumentException("incorrect date of entry format");
        }


        Date startDate = vacationRequestDTO.getStartDate();
        Date endDate = vacationRequestDTO.getEndDate();


        // Validar que la fecha de inicio sea al menos 15 días después de la fecha actual
        Calendar calendar = Calendar.getInstance();



        calendar.add(Calendar.DAY_OF_MONTH, 15);
        Date notificationTime = calendar.getTime();
        if (vacationRequestDTO.getStartDate().before(notificationTime)) {
            logger.info("15 dias");
            throw new IllegalArgumentException("Invalid vacation request. The request must be made at least 15 days in advance.");
        }


        // Validate that the employee has worked at least 2 months.
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        Date minStartDate = calendar.getTime();


        if (dateOfEntry.after(minStartDate)) {
            logger.info("1");
            throw new IllegalArgumentException("Invalid vacation request. Employee must have worked for at least 2 months.");
        }

        // Validate that the start date is not earlier than the entry date

        if (dateOfEntry.after(startDate)  ) {
            logger.info("2");
            throw new IllegalArgumentException("Invalid vacation request. Employee has not reached the minimum service period.");
        }


        // Validar que la diferencia entre la fecha de inicio y la fecha de fin sea al menos 6 días
        long differenceInMillis = endDate.getTime() - startDate.getTime();
        long differenceInDays = TimeUnit.DAYS.convert(differenceInMillis, TimeUnit.MILLISECONDS);
        if (-differenceInDays < 6) {
            logger.info("difeerenceDays :"+differenceInDays);
            logger.info("3");
            throw new IllegalArgumentException("Invalid vacation request. Minimum vacation duration is 6 days.");
        }

        // Validar que el tipo de contrato del empleado sea "labor contract"
        String typeOfContract = (String) employee.get("typeOfContract");
        if (!"labor contract".equalsIgnoreCase(typeOfContract)) {
            logger.info("4");
            throw new IllegalArgumentException("Invalid vacation request. Only employees with labor contract are eligible for vacation.");
        }
    }

    public Map<String, Object> getEmployee(long employeeId) {
        ResponseEntity<String> response = restTemplate.getForEntity(USER_SERVICE_BASE_URL + "/employee/{employeeId}", String.class, employeeId);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> employee = null;
        try {
            employee = objectMapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(String.format("Employee %d not found.", employeeId));
        }
        logger.info(response.getBody());
        return employee;
    }
}
