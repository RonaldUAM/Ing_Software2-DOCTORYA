package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_record.MedicalRecordData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TestData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double cost;
    private Boolean insurance_coverage;
    private LocalDate test_date;
    private String Status;

    @ManyToOne
    @JoinColumn(name = "medical_record_id",referencedColumnName = "id")
    private MedicalRecordData medicalRecordData;
}
