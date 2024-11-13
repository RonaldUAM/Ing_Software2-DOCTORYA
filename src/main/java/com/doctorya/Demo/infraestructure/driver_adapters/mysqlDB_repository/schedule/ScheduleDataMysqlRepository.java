package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDataMysqlRepository extends JpaRepository<ScheduleData,Long> {
}
