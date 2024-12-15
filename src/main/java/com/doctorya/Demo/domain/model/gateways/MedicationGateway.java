package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.Medication;

public interface MedicationGateway {
    Medication findById(Long id);
    Medication saveOrUpdate(Medication medication);
    void delete(Long id);
}
