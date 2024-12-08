package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.dto.MedicalRecordDto;
import com.doctorya.Demo.domain.model.valueObjs.Observation;
import com.doctorya.Demo.domain.model.valueObjs.Symptoms;
import com.doctorya.Demo.domain.model.valueObjs.Treatment;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Diagnosis;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;

public class MedicalRecordDtoMapper {
    private final AppointmentDtoMapper appointmentDtoMapper;

    public MedicalRecordDtoMapper(AppointmentDtoMapper appointmentDtoMapper) {
        this.appointmentDtoMapper = appointmentDtoMapper;
    }

    public MedicalRecordDto toDo(MedicalRecord medicalRecord){
        return new MedicalRecordDto.Builder()
                .id(medicalRecord.getId().getValue())
                .date(medicalRecord.getDate().getValue())
                .symptoms(medicalRecord.getSymptoms().getValue())
                .diagnosis(medicalRecord.getDiagnosis().getValue())
                .treatment(medicalRecord.getTreatment().getValue())
                .observations(medicalRecord.getObservation().getValue())
                .appointment(appointmentDtoMapper.toDo(medicalRecord.getAppointment()))
                .build();
    }

    public MedicalRecord toMedicalRecord(MedicalRecordDto medicalRecordDto){
        return new MedicalRecord.Builder()
                .id(medicalRecordDto.getId() == null ? new Id() : new Id(medicalRecordDto.getId()))
                .date(new Date(medicalRecordDto.getDate()))
                .symptoms(new Symptoms(medicalRecordDto.getSymptoms()))
                .diagnosis(new Diagnosis(medicalRecordDto.getDiagnosis()))
                .treatment(new Treatment(medicalRecordDto.getTreatment()))
                .observation(new Observation(medicalRecordDto.getObservations()))
                .appointment(appointmentDtoMapper.toAppointment(medicalRecordDto.getAppointmentDto()))
                .build();
    }
}
