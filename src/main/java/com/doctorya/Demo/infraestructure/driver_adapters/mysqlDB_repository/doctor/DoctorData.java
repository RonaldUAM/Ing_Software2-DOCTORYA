package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Doctors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DoctorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String identification;
    private String medical_license;
    private String specialty;
    private String email;
    private String phone;
}
