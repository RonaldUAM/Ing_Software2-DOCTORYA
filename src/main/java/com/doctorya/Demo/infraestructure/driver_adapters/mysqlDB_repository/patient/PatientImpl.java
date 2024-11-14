package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.patient;

import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.gateways.PatientGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperPatient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PatientImpl implements PatientGateway {
    private final PatientDataMysqlRepository repository;
    private final MapperPatient mapper;
    @Override
    public Patient findById(Long id) {
        Optional<PatientData> patientData = repository.findById(id);
        return patientData.isEmpty() ? new Patient.Builder().build() : mapper.toDo(patientData.get());
    }
}
