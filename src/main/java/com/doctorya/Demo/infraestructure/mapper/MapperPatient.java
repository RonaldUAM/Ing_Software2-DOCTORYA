package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Patient;
import com.doctorya.Demo.domain.model.valueObjs.Address;
import com.doctorya.Demo.domain.model.valueObjs.BirthDay;
import com.doctorya.Demo.domain.model.valueObjs.Gender;
import com.doctorya.Demo.domain.model.valueObjs.commons.*;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.patient.PatientData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperPatient {
    private final MapperMedicalInsurance mapperMedicalInsurance;
    public Patient toDo(PatientData patientData){
        return new Patient.Builder()
                .id(new Id(patientData.getId()))
                .name(new Name(patientData.getName()))
                .identification(new Identification(patientData.getIdentification()))
                .birthDay(new BirthDay(patientData.getBirth_date()))
                .gender(new Gender(patientData.getGender()))
                .address(new Address(patientData.getAddress()))
                .email(new Email(patientData.getEmail()))
                .phone(new Phone(patientData.getPhone()))
                .medicalInsurance(mapperMedicalInsurance.toDo(patientData.getMedicalInsuranceData()))
                .build();
    }

    public PatientData toData(Patient patient){
        return new PatientData().toBuilder()
                .id(patient.getId() == null ? Long.getLong("") : patient.getId().getValue())
                .name(patient.getName().getvalue())
                .identification(patient.getIdentification().getValue())
                .birth_date(patient.getBirthDay().getValue())
                .gender(patient.getGender().getValue())
                .address(patient.getAddress().getValue())
                .email(patient.getEmail().getValue())
                .phone(patient.getPhone().getValue())
                .medicalInsuranceData(mapperMedicalInsurance.toData(patient.getInsurance()))
                .build();
    }
}
