package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Medication;

public interface MedicationGateway {
    Medication findById(Long id);
}
