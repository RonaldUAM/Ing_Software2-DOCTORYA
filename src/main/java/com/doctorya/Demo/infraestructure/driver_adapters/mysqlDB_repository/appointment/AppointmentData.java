package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor.DoctorData;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.patient.PatientData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Integer time;
    private String reason;
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private PatientData patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private DoctorData doctor;
}
