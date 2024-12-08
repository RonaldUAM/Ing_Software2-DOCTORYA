package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.dto.AppointmentDto;
import com.doctorya.Demo.domain.model.valueObjs.Time;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Reason;
import com.doctorya.Demo.domain.model.valueObjs.commons.Status;

public class AppointmentDtoMapper {
    private final PatientDtoMapper patientDtoMapper;
    private final DoctorDtoMapper doctorDtoMapper;

    public AppointmentDtoMapper(PatientDtoMapper patientDtoMapper, DoctorDtoMapper doctorDtoMapper) {
        this.patientDtoMapper = patientDtoMapper;
        this.doctorDtoMapper = doctorDtoMapper;
    }

    public AppointmentDto toDo(Appointment appointment){
        return new AppointmentDto.Builder()
                .id(appointment.getId().getValue())
                .date(appointment.getDate().getValue())
                .time(appointment.getTime().getValue())
                .status(appointment.getStatus().getValue())
                .patientDto(patientDtoMapper.toDo(appointment.getPatient()))
                .doctorDto(doctorDtoMapper.toDo(appointment.getDoctor()))
                .build();
    }

    public Appointment toAppointment(AppointmentDto appointmentDto){
        return new Appointment.Builder()
                .id(appointmentDto.getId() == null ? new Id() : new Id(appointmentDto.getId()))
                .date(new Date(appointmentDto.getDate()))
                .time(new Time(appointmentDto.getTime()))
                .reason(new Reason(appointmentDto.getReason()))
                .status(new Status(appointmentDto.getStatus()))
                .patient(patientDtoMapper.toDoPatient(appointmentDto.getPatientDto()))
                .doctor(doctorDtoMapper.toDoctor(appointmentDto.getDoctorDto()))
                .build();
    }
}
