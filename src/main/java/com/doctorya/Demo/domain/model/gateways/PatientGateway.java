package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Patient;

public interface PatientGateway {
    Patient findById(Long id);
}
