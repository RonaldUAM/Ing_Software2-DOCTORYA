package com.doctorya.Demo.application.config;

import com.doctorya.Demo.domain.model.gateways.MedicalInsuranceGateway;
import com.doctorya.Demo.domain.model.mapper.MedicalInsuranceDtoMapper;
import com.doctorya.Demo.domain.usecase.MedicalInsuranceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicalInsuranceConfig {
    @Bean
    MedicalInsuranceDtoMapper insuranceDtoMapper(){
        return new MedicalInsuranceDtoMapper();
    }

    @Bean
    MedicalInsuranceUseCase medicalInsuranceUseCase(MedicalInsuranceGateway medicalInsuranceGateway, MedicalInsuranceDtoMapper insuranceDtoMapper){
        return new MedicalInsuranceUseCase(medicalInsuranceGateway,insuranceDtoMapper);
    }
}
