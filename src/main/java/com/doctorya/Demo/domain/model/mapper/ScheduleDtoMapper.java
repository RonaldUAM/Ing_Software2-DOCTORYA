package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.Schedule;
import com.doctorya.Demo.domain.model.dto.commons.DoctorDto;
import com.doctorya.Demo.domain.model.dto.create.ScheduleDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.ScheduleDtoFind;
import com.doctorya.Demo.domain.model.valueObjs.DateTime;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;

public class ScheduleDtoMapper {
    private final DoctorDtoMapper doctorDtoMapper;

    public ScheduleDtoMapper(DoctorDtoMapper doctorDtoMapper) {
        this.doctorDtoMapper = doctorDtoMapper;
    }

    public ScheduleDtoFind toDo(Schedule schedule){
        return new ScheduleDtoFind.Builder()
                .id(schedule.getId().getValue())
                .date(schedule.getDate().getValue())
                .doctor(doctorDtoMapper.toDo(schedule.getDoctor()))
                .build();
    }

    /*public Schedule toScheduleFind(ScheduleDtoFind scheduleDtoFind){
        return new Schedule.Builder()
                .id(scheduleDtoFind.getId() == null ? new Id() : new Id(scheduleDtoFind.getId()))
                .date(new DateTime(scheduleDtoFind.getDate()))
                .doctor(doctorDtoMapper.toDoctor(scheduleDtoFind.getDoctorDto()))
                .build();

    }*/

    public Schedule toScheduleCreate(ScheduleDtoCreate scheduleDtoCreate){
        return new Schedule.Builder()
                .id(scheduleDtoCreate.getId() == null ? new Id() : new Id(scheduleDtoCreate.getId()))
                .date(new DateTime(scheduleDtoCreate.getDate()))
                .doctor(doctorDtoMapper.toDoctor(new DoctorDto.Builder().id(scheduleDtoCreate.getDoctorId()).build()))
                .build();

    }
}
