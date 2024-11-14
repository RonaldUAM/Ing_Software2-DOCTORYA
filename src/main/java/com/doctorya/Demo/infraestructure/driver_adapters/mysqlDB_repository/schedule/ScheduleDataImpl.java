package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.schedule;

import com.doctorya.Demo.domain.model.Schedule;
import com.doctorya.Demo.domain.model.gateways.ScheduleGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperSchedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ScheduleDataImpl implements ScheduleGateway {
    private final ScheduleDataMysqlRepository repository;
    private final MapperSchedule mapper;
    @Override
    public List<Schedule> findByAll() {
        return repository.findAll().stream().map(mapper::toDo).toList();
    }
}
