package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_insurance;

import com.doctorya.Demo.domain.model.MedicalInsurance;
import com.doctorya.Demo.domain.model.gateways.MedicalInsuranceGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperMedicalInsurance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MedicalDataImpl implements MedicalInsuranceGateway {
    private final MedicalIsuranceDataMysqlRepository repository;
    private final MapperMedicalInsurance mapper;
    @Override
    public MedicalInsurance findById(Long id) {
        Optional<MedicalInsuranceData> insuranceData = repository.findById(id);
        return insuranceData.isEmpty() ?
                new MedicalInsurance.Builder().build() : mapper.toDo(insuranceData.get());
    }
}
