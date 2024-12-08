package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.Schedule;
import com.doctorya.Demo.domain.model.dto.ScheduleDto;
import com.doctorya.Demo.domain.model.valueObjs.DateTime;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;

public class ScheduleDtoMapper {
    private final DoctorDtoMapper doctorDtoMapper;

    public ScheduleDtoMapper(DoctorDtoMapper doctorDtoMapper) {
        this.doctorDtoMapper = doctorDtoMapper;
    }

    public ScheduleDto toDo(Schedule schedule){
        return new ScheduleDto.Builder()
                .id(schedule.getId().getValue())
                .date(schedule.getDate().getValue())
                .doctor(doctorDtoMapper.toDo(schedule.getDoctor()))
                .build();
    }

    public Schedule toSchedule(ScheduleDto scheduleDto){
        return new Schedule.Builder()
                .id(scheduleDto.getId() == null ? new Id() : new Id(scheduleDto.getId()))
                .date(new DateTime(scheduleDto.getDate()))
                .doctor(doctorDtoMapper.toDoctor(scheduleDto.getDoctorDto()))
                .build();

    }
}
