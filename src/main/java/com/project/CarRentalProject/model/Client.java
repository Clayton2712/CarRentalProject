package com.project.CarRentalProject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long clientId;

    @Column(unique = true, nullable = false)
    private String clientCellNum;

    private String clientName;
}
