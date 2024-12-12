package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.schedule;

import com.doctorya.Demo.domain.model.Doctor;
import com.doctorya.Demo.domain.model.Schedule;
import com.doctorya.Demo.domain.model.gateways.ScheduleGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperDoctor;
import com.doctorya.Demo.infraestructure.mapper.MapperSchedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ScheduleDataImpl implements ScheduleGateway {
    private final ScheduleDataMysqlRepository repository;
    private final MapperSchedule mapper;
    private final MapperDoctor mapperDoctor;

    @Override
    public Schedule saveOrUpdate(Schedule schedule) {
        return mapper.toDo(repository.save(mapper.toData(schedule)));
    }
}
