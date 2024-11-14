package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.Patient;

import java.util.List;

public interface AppointmentGateway {
    List<Appointment> findByPatient(Patient patient);
}
