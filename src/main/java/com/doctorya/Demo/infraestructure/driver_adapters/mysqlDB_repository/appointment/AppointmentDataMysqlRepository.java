package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.patient.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentDataMysqlRepository extends JpaRepository<AppointmentData,Long> {
    List<AppointmentData> findByPatient(PatientData patient);
}
