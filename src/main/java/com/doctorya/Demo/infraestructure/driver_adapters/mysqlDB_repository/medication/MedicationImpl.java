package com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medication;

import com.doctorya.Demo.domain.model.Medication;
import com.doctorya.Demo.domain.model.gateways.MedicationGateway;
import com.doctorya.Demo.infraestructure.mapper.MapperMedication;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MedicationImpl implements MedicationGateway {
    private MapperMedication mapper;
    private final MedicationDataMysqlRepository repository;
    @Override
    public Medication findById(Long id) {
        Optional<MedicationData> medicationData = repository.findById(id);
        return medicationData.isEmpty() ?
                new Medication.Builder().build() : mapper.toDo(medicationData.get());
    }
}
