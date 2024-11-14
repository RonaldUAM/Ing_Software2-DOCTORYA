package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.MedicalInsurance;

public interface MedicalInsuranceGateway {
    MedicalInsurance findById(Long id);
}
