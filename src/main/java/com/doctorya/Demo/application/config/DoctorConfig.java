package com.doctorya.Demo.application.config;

import com.doctorya.Demo.domain.model.gateways.DoctorGateway;
import com.doctorya.Demo.domain.model.mapper.DoctorDtoMapper;
import com.doctorya.Demo.domain.usecase.DoctorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorConfig {
    @Bean
    public DoctorDtoMapper doctorDtoMapper(){
       return new DoctorDtoMapper();
    }
    @Bean
    public DoctorUseCase doctorUseCase(DoctorGateway doctorGateway, DoctorDtoMapper doctorDtoMapper){
        return new DoctorUseCase(doctorGateway,doctorDtoMapper);
    }
}
