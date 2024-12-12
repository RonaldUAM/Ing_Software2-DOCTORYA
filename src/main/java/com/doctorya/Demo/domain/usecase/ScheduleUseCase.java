package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.Schedule;
import com.doctorya.Demo.domain.model.dto.create.ScheduleDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.ScheduleDtoFind;
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

    private ScheduleDtoFind saveOrUpdate(ScheduleDtoCreate scheduleDtoCreate){
        try {
            Schedule schedule = scheduleGateway.saveOrUpdate(scheduleDtoMapper.toScheduleCreate(scheduleDtoCreate));
            if (scheduleDtoCreate.getId() == null || scheduleDtoCreate.getId().equals(Long.getLong("0"))){
                log.info("Patient create success...");
            }else {
                log.info("Patient update success...");
            }
            return scheduleDtoMapper.toDo(schedule);
        }catch (Exception e){
            log.info(e);
            return new ScheduleDtoFind.Builder().build();
        }
    }
}
