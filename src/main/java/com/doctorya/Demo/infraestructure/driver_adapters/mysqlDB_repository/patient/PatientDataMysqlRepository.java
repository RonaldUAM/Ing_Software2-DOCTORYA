package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDataMysqlRepository extends JpaRepository<PatientData,Long> {
}
