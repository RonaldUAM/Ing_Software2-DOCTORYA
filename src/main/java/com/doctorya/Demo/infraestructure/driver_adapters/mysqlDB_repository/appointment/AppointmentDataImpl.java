package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment;

import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.gateways.AppointmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AppointmentDataImpl implements AppointmentGateway {
    private final AppointmentDataMysqlRepository repository;

    @Override
    public List<AppointmentGateway> findByPatient(Patient patient) {
        return List.of();
    }
}
