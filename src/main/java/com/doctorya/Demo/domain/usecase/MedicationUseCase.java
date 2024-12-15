package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.Medication;
import com.doctorya.Demo.domain.model.dto.create.MedicationDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.MedicationDtoFind;
import com.doctorya.Demo.domain.model.gateways.MedicalRecordGateway;
import com.doctorya.Demo.domain.model.gateways.MedicationGateway;
import com.doctorya.Demo.domain.model.mapper.MedicationDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class MedicationUseCase {
    private final MedicationGateway medicationGateway;
    private final MedicalRecordGateway medicalRecordGateway;
    private final MedicationDtoMapper medicationDtoMapper;

    public MedicationDtoFind save(MedicationDtoCreate medicationDtoCreate) {
        try {
            MedicalRecord medicalRecord = medicalRecordGateway.findById(medicationDtoCreate.getMedicalRecordId());
            Medication medication = medicationGateway.saveOrUpdate(
                    medicationDtoMapper.toMedicationCreate(medicationDtoCreate, medicalRecord)
            );

            if (medicationDtoCreate.getId() == null || medicationDtoCreate.getId().equals(Long.getLong(""))) {
                log.info("Medication Create...");
            } else {
                log.info("Medication Update...");
            }

            return medicationDtoMapper.toDo(medication);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new MedicationDtoFind();
        }
    }

    public boolean delete(Long id) {
        try {
            medicationGateway.delete(id);
            log.info("Medication delete ...");
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
