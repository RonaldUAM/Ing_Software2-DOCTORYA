package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorDataMysqlRepository extends JpaRepository<DoctorData,Long> {
}
