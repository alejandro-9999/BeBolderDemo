package com.bebolder.notificationservice.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


public class AlertDTO {
    private Long alertId;
    private Date shipDate;
    private String message;
    private Long vacation_request_id;

    public AlertDTO(Long alertId, Date shipDate, String message, Long vacation_request_id) {
        this.alertId = alertId;
        this.shipDate = shipDate;
        this.message = message;
        this.vacation_request_id = vacation_request_id;
    }

    public AlertDTO() {
    }

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getVacation_request_id() {
        return vacation_request_id;
    }

    public void setVacation_request_id(Long vacation_request_id) {
        this.vacation_request_id = vacation_request_id;
    }
}
