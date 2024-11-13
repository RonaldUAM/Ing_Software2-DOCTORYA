package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.test_result;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultDataMysqlRepository extends JpaRepository<TestResultData,Long> {
}
