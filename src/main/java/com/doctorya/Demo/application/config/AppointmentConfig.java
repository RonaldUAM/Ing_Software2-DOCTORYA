package com.doctorya.Demo.application.config;

import com.doctorya.Demo.domain.model.gateways.AppointmentGateway;
import com.doctorya.Demo.domain.model.gateways.DoctorGateway;
import com.doctorya.Demo.domain.model.gateways.PatientGateway;
import com.doctorya.Demo.domain.model.mapper.AppointmentDtoMapper;
import com.doctorya.Demo.domain.model.mapper.DoctorDtoMapper;
import com.doctorya.Demo.domain.model.mapper.PatientDtoMapper;
import com.doctorya.Demo.domain.usecase.AppointmentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfig {
    @Bean
    AppointmentDtoMapper appointmentDtoMapper(PatientDtoMapper patientDtoMapper, DoctorDtoMapper doctorDtoMapper){
        return new AppointmentDtoMapper(patientDtoMapper,doctorDtoMapper);
    }

    @Bean
    AppointmentUseCase appointmentUseCase(AppointmentGateway appointmentGateway, PatientGateway patientGateway, DoctorGateway doctorGateway, AppointmentDtoMapper appointmentDtoMapper, DoctorDtoMapper doctorDtoMapper){
        return new AppointmentUseCase(appointmentGateway,patientGateway,doctorGateway,appointmentDtoMapper,doctorDtoMapper);
    }
}
