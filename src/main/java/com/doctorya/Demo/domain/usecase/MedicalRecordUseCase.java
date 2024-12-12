package com.doctorya.Demo.domain.usecase;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.dto.create.MedicalRecordDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.MedicalRecordDtoFind;
import com.doctorya.Demo.domain.model.gateways.AppointmentGateway;
import com.doctorya.Demo.domain.model.gateways.MedicalRecordGateway;
import com.doctorya.Demo.domain.model.mapper.MedicalRecordDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class MedicalRecordUseCase {
    private final MedicalRecordGateway medicalRecordGateway;
    private final AppointmentGateway appointmentGateway;
    private final MedicalRecordDtoMapper medicalRecordDtoMapper;

    public MedicalRecordDtoFind save(MedicalRecordDtoCreate medicalRecordDtoCreate){
        try {
            Appointment appointment = appointmentGateway.findById(medicalRecordDtoCreate.getAppointmentDto());
            MedicalRecord medicalRecord1 = medicalRecordGateway.saveOrUpdate(medicalRecordDtoMapper.toMedicalRecordCreate(medicalRecordDtoCreate,appointment));
            if (medicalRecordDtoCreate.getId() == null || medicalRecordDtoCreate.getId().equals(Long.getLong(""))){
                log.info("Medical Record Create...");
            }else {
                log.info("Medical Record Update...");
            }
            return medicalRecordDtoMapper.toDo(medicalRecord1);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new MedicalRecordDtoFind();
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
