package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test_result;

import com.doctorya.Demo.domain.model.TestResult;
import com.doctorya.Demo.domain.model.gateways.TestResultGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperTestResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TestResultImpl implements TestResultGateway {
    private final TestResultDataMysqlRepository repository;
    private final MapperTestResult mapper;

    @Override
    public List<TestResult> findAll() {
        return repository.findAll().stream().map(mapper::toDo).toList();
    }
}
