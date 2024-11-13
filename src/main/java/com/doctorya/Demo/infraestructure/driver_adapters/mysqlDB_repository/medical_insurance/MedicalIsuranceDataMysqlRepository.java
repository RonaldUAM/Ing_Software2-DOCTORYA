package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_insurance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalIsuranceDataMysqlRepository extends JpaRepository<MedicalInsuranceData,Long> {
}
