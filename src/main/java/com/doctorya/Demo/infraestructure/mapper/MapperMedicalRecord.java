package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.valueObjs.Observation;
import com.doctorya.Demo.domain.model.valueObjs.Symptoms;
import com.doctorya.Demo.domain.model.valueObjs.Treatment;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Diagnosis;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medical_record.MedicalRecordData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperMedicalRecord {
    private final MapperAppointment mapperAppointment;
    public MedicalRecord toDo(MedicalRecordData medicalRecordData){
        return new MedicalRecord.Builder()
                .id(new Id(medicalRecordData.getId()))
                .date(new Date(medicalRecordData.getDate()))
                .symptoms(new Symptoms(medicalRecordData.getSymptoms()))
                .diagnosis(new Diagnosis(medicalRecordData.getDiagnosis()))
                .treatment(new Treatment(medicalRecordData.getTreatment()))
                .observation(new Observation(medicalRecordData.getObservations()))
                .appointment(mapperAppointment.toDo(medicalRecordData.getAppointmentData()))
                .build();
    }
}
