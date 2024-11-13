package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_insurance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Medical_Insurance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MedicalInsuranceData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    private String contact_phone;
}
