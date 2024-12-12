package com.doctorya.Demo.application.config;

import com.doctorya.Demo.domain.model.mapper.DoctorDtoMapper;
import com.doctorya.Demo.domain.model.mapper.ScheduleDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfig {
    @Bean
    ScheduleDtoMapper scheduleDtoMapper(DoctorDtoMapper doctorDtoMapper){
        return new ScheduleDtoMapper(doctorDtoMapper);
    }

}
