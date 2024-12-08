package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor.DoctorData;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.patient.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentDataMysqlRepository extends JpaRepository<AppointmentData,Long> {
    List<AppointmentData> findByPatient_Id(Long patientId);
    @Query("SELECT d FROM DoctorData d " +
            "WHERE d NOT IN (SELECT a.doctor FROM AppointmentData a WHERE a.date = :date AND a.time = :time)")
    List<DoctorData> findDoctorsWithoutAppointmentsAt(@Param("date") LocalDate date, @Param("time") LocalTime time);


    @Query(value = "SELECT EXISTS (SELECT 1 FROM Appointments a WHERE a.doctor_id = :doctorId AND a.date = :date AND a.time = :time)", nativeQuery = true)
    Long existsByDoctorAndDateAndTime(@Param("doctorId") Long doctorId, @Param("date") LocalDate date, @Param("time") LocalTime time);
}
