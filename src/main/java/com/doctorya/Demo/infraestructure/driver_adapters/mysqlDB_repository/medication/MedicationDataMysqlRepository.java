package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationDataMysqlRepository extends JpaRepository<MedicationData,Long> {
}
