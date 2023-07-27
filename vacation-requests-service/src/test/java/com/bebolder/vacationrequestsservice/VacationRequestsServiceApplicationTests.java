package com.bebolder.vacationrequestsservice;
import com.bebolder.vacationrequestsservice.domain.dto.VacationRequestDTO;
import com.bebolder.vacationrequestsservice.domain.repository.IVacationRequestRepository;
import com.bebolder.vacationrequestsservice.domain.service.VacationRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class VacationRequestServiceTest {

    @InjectMocks
    private VacationRequestService vacationRequestService;

    @Mock
    private IVacationRequestRepository vacationRequestRepository;

    @Mock
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        vacationRequestService = new VacationRequestService(restTemplate);
        objectMapper = new ObjectMapper();
    }


    // Caso de prueba: ID de empleado inválido
    @Test()
    @DisplayName("Caso de prueba: ID de empleado inválido")
    public void testValidateVacationRequest_InvalidEmployeeId() {
        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
        vacationRequestDTO.setEmployeeId(-1L); // ID de empleado inválido

        assertThrows(IllegalArgumentException.class, () -> vacationRequestService.validateVacationRequest(vacationRequestDTO));
    }

    // Caso de prueba: Respuesta nula del servicio user-service
    @Test
    @DisplayName("Caso de prueba: Respuesta nula del servicio user-service")
    public void testValidateVacationRequest_NullResponseFromUserService() {
        long employeeId = 6L;

        // Simula que el método restTemplate.getForEntity devuelve un ResponseEntity con contenido nulo
        when(restTemplate.getForEntity(anyString(), eq(String.class), anyLong()))
                .thenReturn(new ResponseEntity<>(null, HttpStatus.OK));

        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
        vacationRequestDTO.setEmployeeId(employeeId);

        // La llamada al método restTemplate devuelve un ResponseEntity con contenido nulo, y el método debería lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> vacationRequestService.validateVacationRequest(vacationRequestDTO));
    }

    // Caso de prueba: Fecha de inicio en el futuro
    @Test
    @DisplayName("Caso de prueba: Fecha solicitud 15 dias antes")
    public void testValidateVacationRequest_FutureStartDate() throws JsonProcessingException {
        long employeeId = 6L;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Fecha de inicio en el futuro (mañana)
        Date startDate = calendar.getTime();
        Date endDate = new Date();

        Map<String, Object> employee = createValidEmployee();

        String employeeJson = objectMapper.writeValueAsString(employee);

        when(restTemplate.getForEntity(anyString(), eq(String.class), anyLong()))
                .thenReturn(new ResponseEntity<>(employeeJson, HttpStatus.OK));

        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
        vacationRequestDTO.setEmployeeId(employeeId);
        vacationRequestDTO.setStartDate(startDate);
        vacationRequestDTO.setEndDate(endDate);

        assertThrows(IllegalArgumentException.class, () -> vacationRequestService.validateVacationRequest(vacationRequestDTO));
    }

    @Test
    @DisplayName("Caso de prueba: Fecha de fin antes de la fecha de inicio")
    public void testValidateVacationRequest_EndDateBeforeStartDate() throws JsonProcessingException {
        long employeeId = 6;
        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1); // Fecha de fin antes de la fecha de inicio (ayer)
        Date endDate = calendar.getTime();

        Map<String, Object> employee = createValidEmployee();

        String employeeJson = objectMapper.writeValueAsString(employee);

        when(restTemplate.getForEntity(anyString(), eq(String.class), anyLong()))
                .thenReturn(new ResponseEntity<>(employeeJson, HttpStatus.OK));

        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
        vacationRequestDTO.setEmployeeId(employeeId);
        vacationRequestDTO.setStartDate(startDate);
        vacationRequestDTO.setEndDate(endDate);

        assertThrows(IllegalArgumentException.class, () -> vacationRequestService.validateVacationRequest(vacationRequestDTO));
    }

    // Caso de prueba: Tipo de contrato no válido
    @Test
    public void testValidateVacationRequest_InvalidEmployeeContract() throws JsonProcessingException {
        long employeeId = 6;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 21); // Fecha de inicio en el futuro (mañana)
        Date startDate = calendar.getTime();
        Date endDate = new Date();

        Map<String, Object> employee = createValidEmployee();

        employee.put("typeOfContract", "Temporal Contract");

        String employeeJson = objectMapper.writeValueAsString(employee);

        when(restTemplate.getForEntity(anyString(), eq(String.class), anyLong()))
                .thenReturn(new ResponseEntity<>(employeeJson, HttpStatus.OK));

        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
        vacationRequestDTO.setEmployeeId(employeeId);
        vacationRequestDTO.setStartDate(startDate);
        vacationRequestDTO.setEndDate(endDate);

        assertThrows(IllegalArgumentException.class, () -> vacationRequestService.validateVacationRequest(vacationRequestDTO));
    }

    // Caso de prueba: Duración de vacaciones mayor que los días acumulados
    @Test
    public void testValidateVacationRequest_DurationGreaterThanAccruedDays() throws JsonProcessingException {
        long employeeId = 6;
        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, 20); // Duración de vacaciones mayor que los días acumulados (supongamos que solo tiene 15 días acumulados)
        Date endDate = calendar.getTime();

        Map<String, Object> employee = createValidEmployee();

        String employeeJson = objectMapper.writeValueAsString(employee);

        when(restTemplate.getForEntity(anyString(), eq(String.class), anyLong()))
                .thenReturn(new ResponseEntity<>(employeeJson, HttpStatus.OK));

        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
        vacationRequestDTO.setEmployeeId(employeeId);
        vacationRequestDTO.setStartDate(startDate);
        vacationRequestDTO.setEndDate(endDate);

        assertThrows(IllegalArgumentException.class, () -> vacationRequestService.validateVacationRequest(vacationRequestDTO));
    }

    // Caso de prueba: Fecha de inicio justo en el límite del mínimo de 2 meses de servicio
//    @Test
//    public void testValidateVacationRequest_ValidStartDateOnMinimumServiceBoundary() throws JsonProcessingException {
//        long employeeId = 6;
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, -60); // Fecha de inicio justo en el límite del mínimo de 2 meses de servicio
//        Date startDate = calendar.getTime();
//        Date endDate = new Date();
//
//        Map<String, Object> employee = createValidEmployee();
//
//        String employeeJson = objectMapper.writeValueAsString(employee);
//
//        when(restTemplate.getForEntity(anyString(), eq(String.class), anyLong()))
//                .thenReturn(new ResponseEntity<>(employeeJson, HttpStatus.OK));
//
//        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
//        vacationRequestDTO.setEmployeeId(employeeId);
//        vacationRequestDTO.setStartDate(startDate);
//        vacationRequestDTO.setEndDate(endDate);
//
//        assertDoesNotThrow(() -> vacationRequestService.validateVacationRequest(vacationRequestDTO));
//    }





    private VacationRequestDTO createValidVacationRequest() {
        VacationRequestDTO vacationRequest = new VacationRequestDTO();
        vacationRequest.setEmployeeId(1);
        vacationRequest.setStartDate(new Date());
        vacationRequest.setEndDate(addDaysToDate(new Date(), 10));
        return vacationRequest;
    }

    private Map<String, Object> createValidEmployee() {
        Map<String, Object> employee = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        employee.put("dateOfEntry",formatter.format(addMonthsToDate(new Date(), -2))); // Set dateOfEntry 60 days ago
        employee.put("typeOfContract", "Labor Contract");
        return employee;
    }

    private Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date addMonthsToDate(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }
}
