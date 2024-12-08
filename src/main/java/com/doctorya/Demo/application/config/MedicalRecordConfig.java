package com.doctorya.Demo.application.config;

import com.doctorya.Demo.domain.model.gateways.MedicalRecordGateway;
import com.doctorya.Demo.domain.model.mapper.AppointmentDtoMapper;
import com.doctorya.Demo.domain.model.mapper.MedicalRecordDtoMapper;
import com.doctorya.Demo.domain.usecase.MedicalRecordUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicalRecordConfig {

    @Bean
    public MedicalRecordDtoMapper medicalRecordDtoMapper(AppointmentDtoMapper appointmentDtoMapper){
        return new MedicalRecordDtoMapper(appointmentDtoMapper);
    }

    @Bean
    public MedicalRecordUseCase medicalRecordUseCase(MedicalRecordGateway medicalRecordGateway, MedicalRecordDtoMapper medicalRecordDtoMapper){
        return new MedicalRecordUseCase(medicalRecordGateway,medicalRecordDtoMapper);
    }
}
