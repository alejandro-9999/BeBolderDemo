package com.bebolder.notificationservice.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "alert")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ship_date")
    private Date shipDate;

    private String message;

    private long vacation_request_id;

    public Alert(){

    }
    public Alert(long id, Date shipDate, String message, long vacation_request_id) {
        this.id = id;
        this.shipDate = shipDate;
        this.message = message;
        this.vacation_request_id = vacation_request_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getVacation_request_id() {
        return vacation_request_id;
    }

    public void setVacation_request_id(long vacation_request_id) {
        this.vacation_request_id = vacation_request_id;
    }
}
