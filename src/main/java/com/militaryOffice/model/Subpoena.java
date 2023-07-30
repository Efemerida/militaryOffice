package com.militaryOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "subpoena")
public class Subpoena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"idUser\"", nullable = false)
    private Citizen idUser;

    @Column(name = "\"dateOfDelivery\"", nullable = false)
    private LocalDate dateOfDelivery;

    @Column(name = "\"dateOfAttendance\"", nullable = false)
    private LocalDate dateOfAttendance;

    @Column(name = "reason", nullable = false, length = 150)
    private String reason;

    @Column(name = "documents", nullable = false, length = 150)
    private String documents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "militaryOfficeId", referencedColumnName = "id")
    private MilitaryOffice militaryOffice;

}