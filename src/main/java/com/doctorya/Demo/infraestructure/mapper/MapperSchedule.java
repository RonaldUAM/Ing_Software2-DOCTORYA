package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.Schedule;
import com.doctorya.Demo.domain.model.valueObjs.DateTime;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.schedule.ScheduleData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MapperSchedule {
    public Schedule toDo(ScheduleData scheduleData){
        return new Schedule.Builder()
                .id(new Id(scheduleData.getId()))
                .date(convertDate(scheduleData.getHour(), scheduleData.getDay(), scheduleData.getMonth(), scheduleData.getYear()))
                .build();
    }

    public ScheduleData toData(Schedule schedule){
        return new ScheduleData().toBuilder()
                .id(schedule.getId().getValue())
                .day(schedule.getDate().getValue().getDayOfMonth())
                .hour(schedule.getDate().getValue().getHour())
                .month(schedule.getDate().getValue().getMonthValue())
                .year(schedule.getDate().getValue().getYear())
                .build();
    }

    private DateTime convertDate(Integer hour, Integer day, Integer month, Integer year){
        return new DateTime(LocalDateTime.of(year,month,day,hour,0));
    }
}
