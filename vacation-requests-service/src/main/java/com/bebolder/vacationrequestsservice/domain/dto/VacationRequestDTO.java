package com.bebolder.vacationrequestsservice.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VacationRequestDTO {
    private long vacationRequestId;

    private int days;
    private Date startDate;
    private Date endDate;
    private String status;
    private long employeeId;
}
