package com.doctorya.Demo.application.config;

import com.doctorya.Demo.domain.model.dto.PatientDto;
import com.doctorya.Demo.domain.model.gateways.MedicalInsuranceGateway;
import com.doctorya.Demo.domain.model.gateways.PatientGateway;
import com.doctorya.Demo.domain.model.mapper.*;
import com.doctorya.Demo.domain.usecase.MedicalInsuranceUseCase;
import com.doctorya.Demo.domain.usecase.PatientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfig {

    @Bean
    PatientDtoMapper patientDtoMapper(MedicalInsuranceDtoMapper insuranceDtoMapper){
        return new PatientDtoMapper(insuranceDtoMapper);
    }

    @Bean
    PatientUseCase patientUseCase(PatientGateway patientGateway, PatientDtoMapper PatientDtoMapper, MedicalInsuranceUseCase medicalInsuranceUseCase){
        return new PatientUseCase(patientGateway, PatientDtoMapper,medicalInsuranceUseCase);
    }

}
