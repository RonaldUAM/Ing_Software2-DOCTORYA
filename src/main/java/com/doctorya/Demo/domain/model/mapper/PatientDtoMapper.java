package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.dto.PatientDto;
import com.doctorya.Demo.domain.model.valueObjs.Address;
import com.doctorya.Demo.domain.model.valueObjs.BirthDay;
import com.doctorya.Demo.domain.model.valueObjs.Gender;
import com.doctorya.Demo.domain.model.valueObjs.commons.*;

public class PatientDtoMapper {
    private final MedicalInsuranceDtoMapper insuranceDtoMapper;

    public PatientDtoMapper(MedicalInsuranceDtoMapper insuranceDtoMapper) {
        this.insuranceDtoMapper = insuranceDtoMapper;
    }

    public Patient toDoPatient(PatientDto patientDto){
        return new Patient.Builder()
                .id(patientDto.getId() == null ? new Id() : new Id(patientDto.getId()))
                .name(new Name(patientDto.getName()))
                .identification(new Identification(patientDto.getIdentification()))
                .birthDay(new BirthDay(patientDto.getBirthDay()))
                .gender(new Gender(patientDto.getGender()))
                .address(new Address(patientDto.getAddress()))
                .email(new Email(patientDto.getEmail()))
                .phone(new Phone(patientDto.getPhone()))
                .medicalInsurance(insuranceDtoMapper.toDoMedicalInsurance(patientDto.getInsurance()))
                .build();
    }

    public PatientDto toDo(Patient patient){
        return new PatientDto.Builder()
                .id(patient.getId() == null ? null : patient.getId().getValue())
                .name(patient.getName().getvalue())
                .identification(patient.getIdentification().getValue())
                .birthDay(patient.getBirthDay().getValue())
                .gender(patient.getGender().getValue())
                .address(patient.getAddress().getValue())
                .email(patient.getEmail().getValue())
                .phone(patient.getPhone().getValue())
                .insurance(insuranceDtoMapper.toDo(patient.getInsurance()))
                .build();
    }
}
