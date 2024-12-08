package com.doctorya.Demo.domain.model.gateways;

import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.dto.DoctorDto;

import java.util.List;

public interface DoctorGateway {
    Doctor findById(Long id);
    List<Doctor> findAll();
    Doctor saveOrUpdate(Doctor doctor);
    void deleteById(Long id);
}
