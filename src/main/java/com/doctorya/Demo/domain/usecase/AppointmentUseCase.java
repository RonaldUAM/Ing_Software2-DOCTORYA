package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.dto.AppointmentDto;
import com.doctorya.Demo.domain.model.dto.DoctorDto;
import com.doctorya.Demo.domain.model.gateways.AppointmentGateway;
import com.doctorya.Demo.domain.model.mapper.AppointmentDtoMapper;
import com.doctorya.Demo.domain.model.mapper.DoctorDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Log4j2
public class AppointmentUseCase {
    private final AppointmentGateway appointmentGateway;
    private final AppointmentDtoMapper appointmentDtoMapper;
    private final DoctorDtoMapper doctorDtoMapper;

    public List<AppointmentDto> findAll(){
        return appointmentGateway.findAll().stream().map(appointmentDtoMapper::toDo).toList();
    }

    public List<AppointmentDto> findByPatient(Long patient_id){
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

    public AppointmentDto createAppointment(AppointmentDto appointmentDto){
        try {
            Appointment appointment = appointmentDtoMapper.toAppointment(appointmentDto);
            boolean avalaibleDoctor = appointmentGateway.existsByDoctorAndDateAndTime(appointment);

            if (!avalaibleDoctor){
                if (appointmentDto.getId() == null || appointmentDto.getId().equals(Long.getLong("0"))){
                    log.info("Appointment create success...");
                }else {
                    log.info("Appointment update success...");
                }
                return appointmentDtoMapper.toDo(appointmentGateway.saveOrUpdate(appointment));
            }
            log.error("Doctor is not Avalaible...");
            return new AppointmentDto();
        }catch (Exception e){
            log.error(e.getMessage());
            return new AppointmentDto();
        }
    }

}
