package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_record;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment.AppointmentData;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Medical_Records")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class MedicalRecordData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String observations;

    @OneToOne
    @JoinColumn(name = "appointment_id",referencedColumnName = "id")
    private AppointmentData appointmentData;
}
