package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDataMysqlRepository extends JpaRepository<TestData,Long> {
}
