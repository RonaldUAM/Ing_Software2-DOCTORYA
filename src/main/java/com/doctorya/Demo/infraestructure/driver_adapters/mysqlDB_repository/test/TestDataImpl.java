package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test;

import com.doctorya.Demo.domain.model.Test;
import com.doctorya.Demo.domain.model.gateways.TestGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperTest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TestDataImpl implements TestGateway {
    private final TestDataMysqlRepository repository;
    private final MapperTest mapper;

    @Override
    public List<Test> findAll() {
        return repository.findAll().stream().map(mapper::toDo).toList();
    }
}
