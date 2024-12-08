package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.appointment;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.gateways.AppointmentGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperAppointment;
import com.doctorya.Demo.infraestructure.mapper.MapperDoctor;
import com.doctorya.Demo.infraestructure.mapper.MapperPatient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AppointmentDataImpl implements AppointmentGateway {
    private final AppointmentDataMysqlRepository repository;
    private final MapperAppointment mapper;
    private final MapperPatient mapperPatient;
    private final MapperDoctor mapperDoctor;
    @Override
    public List<Appointment> findByPatient(Long patient_id) {
        return repository.findByPatient_Id(patient_id).stream().map(mapper::toDo).toList();
    }

    @Override
    public List<Appointment> findAll() {
        return repository.findAll().stream().map(mapper::toDo).toList();
    }

    @Override
    public List<Doctor> findDoctorByAppointment(LocalTime time, LocalDate date) {
        return repository.findDoctorsWithoutAppointmentsAt(date,time).stream().map(mapperDoctor::toDo).toList();
    }

    @Override
    public Boolean existsByDoctorAndDateAndTime(Appointment appointment) {
        Long aLong = repository.existsByDoctorAndDateAndTime(appointment.getDoctor().getId().getValue(),
                appointment.getDate().getValue(),
                appointment.getTime().getValue());
        if (aLong == 1){
            return true;
        }
        return false;
    }

    @Override
    public Appointment saveOrUpdate(Appointment appointment) {
        return mapper.toDo(repository.save(mapper.toData(appointment)));
    }
}
