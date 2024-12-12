package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.report;

import com.doctorya.Demo.domain.model.Report;
import com.doctorya.Demo.domain.model.gateways.ReportGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperReport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ReportDataImpl implements ReportGateway {

    private final ReposrtDataMysqlRepository repository;
    private final MapperReport mapper;

    @Override
    public List<Report> findAll(){
        return repository.findAll().stream().map(mapper::toDo).toList();
    }
}
