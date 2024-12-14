package com.doctorya.Demo.application.config;

import com.doctorya.Demo.domain.model.gateways.MedicalRecordGateway;
import com.doctorya.Demo.domain.model.gateways.MedicationGateway;
import com.doctorya.Demo.domain.model.mapper.MedicalRecordDtoMapper;
import com.doctorya.Demo.domain.model.mapper.MedicationDtoMapper;
import com.doctorya.Demo.domain.usecase.MedicationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicationConfig {

    @Bean
    public MedicationDtoMapper medicationDtoMapper(MedicalRecordDtoMapper medicalRecordDtoMapper) {
        return new MedicationDtoMapper(medicalRecordDtoMapper);
    }

    @Bean
    public MedicationUseCase medicationUseCase(
            MedicationGateway medicationGateway,
            MedicalRecordGateway medicalRecordGateway,
            MedicationDtoMapper medicationDtoMapper
    ) {
        return new MedicationUseCase(medicationGateway, medicalRecordGateway, medicationDtoMapper);
    }
}
