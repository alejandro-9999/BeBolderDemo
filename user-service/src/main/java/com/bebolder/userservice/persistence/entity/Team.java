package com.bebolder.userservice.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "team")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "team")
    private List<Employee> members;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;
}