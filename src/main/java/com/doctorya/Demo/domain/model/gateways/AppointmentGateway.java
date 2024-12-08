package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentGateway {
    List<Appointment> findByPatient(Long patient_id);
    List<Appointment> findAll();
    List<Doctor> findDoctorByAppointment(LocalTime time, LocalDate date);
    Boolean existsByDoctorAndDateAndTime(Appointment appointment);
    Appointment saveOrUpdate(Appointment appointment);
}
