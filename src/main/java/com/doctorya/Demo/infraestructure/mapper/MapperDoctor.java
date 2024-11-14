package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.valueObjs.MedicalLicense;
import com.doctorya.Demo.domain.model.valueObjs.Specialty;
import com.doctorya.Demo.domain.model.valueObjs.commons.*;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor.DoctorData;
import org.springframework.stereotype.Component;

@Component
public class MapperDoctor {
    public Doctor toDo(DoctorData doctorData){
        return new Doctor.Builder()
                .id(new Id(doctorData.getId()))
                .name(new Name(doctorData.getName()))
                .identification(new Identification(doctorData.getIdentification()))
                .medicalLicense(new MedicalLicense(doctorData.getMedical_license()))
                .specialty(new Specialty(doctorData.getSpecialty()))
                .email(new Email(doctorData.getEmail()))
                .phone(new Phone(doctorData.getPhone()))
                .build();
    }
}
