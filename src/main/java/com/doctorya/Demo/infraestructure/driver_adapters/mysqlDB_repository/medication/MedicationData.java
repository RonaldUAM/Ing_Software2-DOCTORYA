package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medication;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_record.MedicalRecordData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Medications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MedicationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;
    private String active_ingredient;
    private String dosage_form;
    private String dosage;
    private String usage_instructions;
    private String treatment_duration;
    private String status;

    @ManyToOne
    @JoinColumn(name = "medical_record_id", referencedColumnName = "id")
    private MedicalRecordData medicalRecordData;
}
