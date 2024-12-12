package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.referral;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferralDataMysqlRepository extends JpaRepository<ReferralData,Long> {
}
