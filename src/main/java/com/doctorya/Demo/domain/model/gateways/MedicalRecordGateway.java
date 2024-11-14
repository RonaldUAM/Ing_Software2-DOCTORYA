package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.MedicalRecord;

public interface MedicalRecordGateway {
    MedicalRecord findById(Long id);
}
