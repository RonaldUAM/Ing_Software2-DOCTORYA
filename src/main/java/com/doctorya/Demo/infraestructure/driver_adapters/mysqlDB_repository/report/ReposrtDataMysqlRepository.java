package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReposrtDataMysqlRepository extends JpaRepository<ReportData,Long> {
}
