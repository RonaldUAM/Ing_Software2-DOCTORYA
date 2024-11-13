package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_record;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordDataMysqlRepository extends JpaRepository<MedicalRecordData,Long> {
}
