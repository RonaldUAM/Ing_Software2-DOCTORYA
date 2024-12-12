package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.schedule;

import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDataMysqlRepository extends JpaRepository<ScheduleData,Long> {
}
