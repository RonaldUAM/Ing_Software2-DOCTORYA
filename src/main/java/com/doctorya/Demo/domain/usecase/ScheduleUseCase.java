package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.Schedule;
import com.doctorya.Demo.domain.model.dto.ScheduleDto;
import com.doctorya.Demo.domain.model.gateways.ScheduleGateway;
import com.doctorya.Demo.domain.model.mapper.ScheduleDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
//Hay que cambiarlo por que no es lo que piden :,<
public class ScheduleUseCase {
    private final ScheduleGateway scheduleGateway;
    private final ScheduleDtoMapper scheduleDtoMapper;

    private ScheduleDto saveOrUpdate(ScheduleDto scheduleDto){
        try {
            Schedule schedule = scheduleGateway.saveOrUpdate(scheduleDtoMapper.toSchedule(scheduleDto));
            if (scheduleDto.getId() == null || scheduleDto.getId().equals(Long.getLong("0"))){
                log.info("Patient create success...");
            }else {
                log.info("Patient update success...");
            }
            return scheduleDtoMapper.toDo(schedule);
        }catch (Exception e){
            log.info(e);
            return new ScheduleDto.Builder().build();
        }
    }
}
