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
public class VacationRequestDTO {
    private long vacationRequestId;

    private int days;
    private Date startDate;
    private Date endDate;
    private long employeeId;

    public long getVacationRequestId() {
        return vacationRequestId;
    }

    public void setVacationRequestId(long vacationRequestId) {
        this.vacationRequestId = vacationRequestId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
