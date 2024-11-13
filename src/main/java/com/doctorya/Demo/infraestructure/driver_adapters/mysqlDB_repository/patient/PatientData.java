package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.patient;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_insurance.MedicalInsuranceData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Patients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PatientData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String identification;
    private LocalDate birth_date;
    private String gender;
    private String address;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "insurance_id",referencedColumnName = "id")
    private MedicalInsuranceData medicalInsuranceData;
}
