package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.dto.create.AppointmentDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.AppointmentDtoFind;
import com.doctorya.Demo.domain.model.dto.commons.DoctorDto;
import com.doctorya.Demo.domain.model.gateways.AppointmentGateway;
import com.doctorya.Demo.domain.model.gateways.DoctorGateway;
import com.doctorya.Demo.domain.model.gateways.PatientGateway;
import com.doctorya.Demo.domain.model.mapper.AppointmentDtoMapper;
import com.doctorya.Demo.domain.model.mapper.DoctorDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Log4j2
public class AppointmentUseCase {
    private final AppointmentGateway appointmentGateway;
    private final PatientGateway patientGateway;
    private final DoctorGateway doctorGateway;
    private final AppointmentDtoMapper appointmentDtoMapper;
    private final DoctorDtoMapper doctorDtoMapper;

    public List<AppointmentDtoFind> findAll(){
        return appointmentGateway.findAll().stream().map(appointmentDtoMapper::toDo).toList();
    }

    public List<AppointmentDtoFind> findByPatient(Long patient_id){
        return appointmentGateway.findByPatient(patient_id).stream().map(appointmentDtoMapper::toDo).toList();
    }


    public List<DoctorDto> findDoctorByAppointmentAvailable(LocalTime time, LocalDate date){
        try {
            log.info("Checking doctor's availability");
            return appointmentGateway.findDoctorByAppointment(time,date).stream().map(doctorDtoMapper::toDo).toList();
        }catch (Exception e){
            log.error(e.getMessage());
            return List.of();
        }
    }

    public AppointmentDtoFind createAppointment(AppointmentDtoCreate appointmentDtoCreate){
        try {
            Patient patient = patientGateway.findById(appointmentDtoCreate.getPatientDto());
            Doctor doctor = doctorGateway.findById(appointmentDtoCreate.getDoctorDto());
            Appointment appointment = appointmentDtoMapper.toAppointmentCreate(appointmentDtoCreate,patient,doctor);
            boolean avalaibleDoctor = appointmentGateway.existsByDoctorAndDateAndTime(appointment);

            if (!avalaibleDoctor){
                if (appointmentDtoCreate.getId() == null || appointmentDtoCreate.getId().equals(Long.getLong("0"))){
                    log.info("Appointment create success...");
                }else {
                    log.info("Appointment update success...");
                }
                return appointmentDtoMapper.toDo(appointmentGateway.saveOrUpdate(appointment));
            }
            log.error("Doctor is not Avalaible...");
            return new AppointmentDtoFind();
        }catch (Exception e){
            log.error(e.getMessage());
            return new AppointmentDtoFind();
        }
    }

}
