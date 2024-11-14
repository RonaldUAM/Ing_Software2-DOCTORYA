package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.gateways.AppointmentGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperAppointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AppointmentDataImpl implements AppointmentGateway {
    private final AppointmentDataMysqlRepository repository;
    private final MapperAppointment mapper;
    @Override
    public List<Appointment> findByPatient(Patient patient) {
        return repository.findAll().stream().map(mapper::toDo).toList();
    }
}
