package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.dto.MedicalRecordDto;
import com.doctorya.Demo.domain.model.gateways.MedicalRecordGateway;
import com.doctorya.Demo.domain.model.mapper.MedicalRecordDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class MedicalRecordUseCase {
    private final MedicalRecordGateway medicalRecordGateway;
    private final MedicalRecordDtoMapper medicalRecordDtoMapper;

    public MedicalRecordDto save(MedicalRecordDto medicalRecord){
        try {
            MedicalRecord medicalRecord1 = medicalRecordGateway.saveOrUpdate(medicalRecordDtoMapper.toMedicalRecord(medicalRecord));
            if (medicalRecord.getId() == null || medicalRecord.getId().equals(Long.getLong(""))){
                log.info("Medical Record Create...");
            }else {
                log.info("Medical Record Update...");
            }
            return medicalRecordDtoMapper.toDo(medicalRecord1);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new MedicalRecordDto();
        }
    }

    public boolean delete(Long id){
        try {
            medicalRecordGateway.delete(id);
            log.info("Medical Record delete ...");
            return true;
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }
}
