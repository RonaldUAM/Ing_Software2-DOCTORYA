package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.dto.commons.DoctorDto;
import com.doctorya.Demo.domain.model.valueObjs.MedicalLicense;
import com.doctorya.Demo.domain.model.valueObjs.Specialty;
import com.doctorya.Demo.domain.model.valueObjs.commons.*;

public class DoctorDtoMapper {

    public DoctorDto toDo(Doctor doctor){
        return new DoctorDto.Builder()
                .id(doctor.getId().getValue())
                .name(doctor.getName().getvalue())
                .identification(doctor.getIdentification().getValue())
                .medicalLicense(doctor.getMedicalLicense().getValue())
                .speciality(doctor.getSpecialty().getValue())
                .email(doctor.getEmaill().getValue())
                .phone(doctor.getPhone().getValue())
                .build();
    }

    public Doctor toDoctor(DoctorDto doctorDto){
        return new Doctor.Builder()
                .id(doctorDto.getId() == null ? new Id() : new Id(doctorDto.getId()))
                .name(new Name(doctorDto.getName()))
                .identification(new Identification(doctorDto.getIdentification()))
                .medicalLicense(new MedicalLicense(doctorDto.getMedicalLicense()))
                .specialty(new Specialty(doctorDto.getSpeciality()))
                .email(new Email(doctorDto.getEmail()))
                .phone(new Phone(doctorDto.getPhone()))
                .build();
    }
}
