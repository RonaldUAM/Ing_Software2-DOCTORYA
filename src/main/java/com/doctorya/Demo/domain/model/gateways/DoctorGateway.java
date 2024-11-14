package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Doctor;

public interface DoctorGateway {
    Doctor findById(Long id);
}
