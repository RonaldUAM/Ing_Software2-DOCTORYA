package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.report;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ReportDataImpl {
    private ReposrtDataMysqlRepository repository;

    public List<ReportData> findAll(){
        return repository.findAll();
    }
}
