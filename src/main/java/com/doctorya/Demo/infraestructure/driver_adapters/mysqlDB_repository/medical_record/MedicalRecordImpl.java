package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_record;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.gateways.MedicalRecordGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperMedicalRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MedicalRecordImpl implements MedicalRecordGateway {
    private final MedicalRecordDataMysqlRepository repository;
    private final MapperMedicalRecord mapper;
    @Override
    public MedicalRecord findById(Long id) {
        Optional<MedicalRecordData> medicalRecordData = repository.findById(id);
        return medicalRecordData.isEmpty() ? new MedicalRecord.Builder().build() : mapper.toDo(medicalRecordData.get());
    }
}
