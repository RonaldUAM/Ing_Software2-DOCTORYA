package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.Appointment;
import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.dto.create.AppointmentDtoCreate;
import com.doctorya.Demo.domain.model.dto.create.MedicalRecordDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.MedicalRecordDtoFind;
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

    public MedicalRecordDtoFind toDo(MedicalRecord medicalRecord){
        return new MedicalRecordDtoFind.Builder()
                .id(medicalRecord.getId().getValue())
                .date(medicalRecord.getDate().getValue())
                .symptoms(medicalRecord.getSymptoms().getValue())
                .diagnosis(medicalRecord.getDiagnosis().getValue())
                .treatment(medicalRecord.getTreatment().getValue())
                .observations(medicalRecord.getObservation().getValue())
                .appointment(appointmentDtoMapper.toDo(medicalRecord.getAppointment()))
                .build();
    }

    public MedicalRecord toMedicalRecordCreate(MedicalRecordDtoCreate medicalRecordDtoCreate, Appointment appointment){
        return new MedicalRecord.Builder()
                .id(medicalRecordDtoCreate.getId() == null ? new Id() : new Id(medicalRecordDtoCreate.getId()))
                .date(new Date(medicalRecordDtoCreate.getDate()))
                .symptoms(new Symptoms(medicalRecordDtoCreate.getSymptoms()))
                .diagnosis(new Diagnosis(medicalRecordDtoCreate.getDiagnosis()))
                .treatment(new Treatment(medicalRecordDtoCreate.getTreatment()))
                .observation(new Observation(medicalRecordDtoCreate.getObservations()))
                .appointment(appointment)
                .build();
    }
}
