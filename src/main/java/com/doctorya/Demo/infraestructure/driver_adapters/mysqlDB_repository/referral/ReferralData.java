package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.referral;


import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor.DoctorData;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_record.MedicalRecordData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Referrals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReferralData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private String reason_for_referral;

    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private DoctorData doctorData;

    @ManyToOne
    @JoinColumn(name = "medical_record_id",referencedColumnName = "id")
    private MedicalRecordData medicalRecordData;
}
