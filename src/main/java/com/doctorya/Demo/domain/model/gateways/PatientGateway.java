package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Patient;

import java.util.List;

public interface PatientGateway {
    Patient findById(Long id);
    Patient saveOrUpdate(Patient patient);
    List<Patient> findAll();
    void deleteById(Long id);
}
