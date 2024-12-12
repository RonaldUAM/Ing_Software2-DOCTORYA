package com.doctorya.Demo.infraestructure.mapper;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.Medication;
import com.doctorya.Demo.domain.model.valueObjs.*;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;
import com.doctorya.Demo.domain.model.valueObjs.commons.Status;
import com.doctorya.Demo.infraestructure.driver_adapters.mysqlDB_repository.medication.MedicationData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperMedication {
    private final MapperMedicalRecord mapperMedicalRecord;
    public Medication toDo(MedicationData medicationData){
        return new Medication.Builder()
                .id(new Id(medicationData.getId()))
                .name(new Name(medicationData.getName()))
                .activeIngredient(new ActiveIngredient(medicationData.getActive_ingredient()))
                .dosageForm(new DosageForm(medicationData.getDosage_form()))
                .dosage(new Dosage(medicationData.getDosage()))
                .usasgeInstruction(new UsasgeInstruction(medicationData.getUsage_instructions()))
                .treatmentDuration(new TreatmentDuration(medicationData.getTreatment_duration()))
                .status(new Status(medicationData.getStatus()))
                .medicalRecord(mapperMedicalRecord.toDo(medicationData.getMedicalRecordData()))
                .build();
    }
}
