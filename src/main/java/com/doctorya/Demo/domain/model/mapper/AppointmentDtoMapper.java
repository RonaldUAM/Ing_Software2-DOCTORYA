package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.dto.create.AppointmentDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.AppointmentDtoFind;
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

    public AppointmentDtoFind toDo(Appointment appointment){
        return new AppointmentDtoFind.Builder()
                .id(appointment.getId().getValue())
                .date(appointment.getDate().getValue())
                .time(appointment.getTime().getValue())
                .status(appointment.getStatus().getValue())
                .patientDto(patientDtoMapper.toDo(appointment.getPatient()))
                .doctorDto(doctorDtoMapper.toDo(appointment.getDoctor()))
                .build();
    }

    public Appointment toAppointment(AppointmentDtoFind appointmentDtoFind){
        return new Appointment.Builder()
                .id(appointmentDtoFind.getId() == null ? new Id() : new Id(appointmentDtoFind.getId()))
                .date(new Date(appointmentDtoFind.getDate()))
                .time(new Time(appointmentDtoFind.getTime()))
                .reason(new Reason(appointmentDtoFind.getReason()))
                .status(new Status(appointmentDtoFind.getStatus()))
                .patient(patientDtoMapper.toDoPatient(appointmentDtoFind.getPatientDto()))
                .doctor(doctorDtoMapper.toDoctor(appointmentDtoFind.getDoctorDto()))
                .build();
    }

    public Appointment toAppointmentCreate(AppointmentDtoCreate appointmentDtoCreate, Patient patient, Doctor doctor){
        return new Appointment.Builder()
                .id(appointmentDtoCreate.getId() == null ? new Id() : new Id(appointmentDtoCreate.getId()))
                .date(new Date(appointmentDtoCreate.getDate()))
                .time(new Time(appointmentDtoCreate.getTime()))
                .reason(new Reason(appointmentDtoCreate.getReason()))
                .status(new Status(appointmentDtoCreate.getStatus()))
                .patient(patient)
                .doctor(doctor)
                .build();
    }
}
