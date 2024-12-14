package com.doctorya.Demo.domain.model.mapper;

import com.doctorya.Demo.domain.model.MedicalRecord;
import com.doctorya.Demo.domain.model.Medication;
import com.doctorya.Demo.domain.model.dto.create.MedicationDtoCreate;
import com.doctorya.Demo.domain.model.dto.search.MedicationDtoFind;
import com.doctorya.Demo.domain.model.valueObjs.*;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;
import com.doctorya.Demo.domain.model.valueObjs.commons.Status;

public class MedicationDtoMapper {
    private final MedicalRecordDtoMapper medicalRecordDtoMapper;

    public MedicationDtoMapper(MedicalRecordDtoMapper medicalRecordDtoMapper) {
        this.medicalRecordDtoMapper = medicalRecordDtoMapper;
    }

    public MedicationDtoFind toDo(Medication medication) {
        return new MedicationDtoFind.Builder()
                .id(medication.getId().getValue())
                .name(medication.getName().getvalue())
                .activeIngredient(medication.getActiveIngredient().getValue())
                .dosageForm(medication.getDosageForm().getValue())
                .dosage(medication.getDosage().getValue())
                .usageInstruction(medication.getUsasgeInstruction().getValue())
                .treatmentDuration(medication.getTreatmentDuration().getValue())
                .status(medication.getStatus().getValue())
                .medicalRecord(medicalRecordDtoMapper.toDo(medication.getMedicalRecord()))
                .build();
    }

    public Medication toMedicationCreate(MedicationDtoCreate medicationDtoCreate, MedicalRecord medicalRecord) {
        return new Medication.Builder()
                .id(medicationDtoCreate.getId() == null ? new Id() : new Id(medicationDtoCreate.getId()))
                .name(new Name(medicationDtoCreate.getName()))
                .activeIngredient(new ActiveIngredient(medicationDtoCreate.getActiveIngredient()))
                .dosageForm(new DosageForm(medicationDtoCreate.getDosageForm()))
                .dosage(new Dosage(medicationDtoCreate.getDosage()))
                .usasgeInstruction(new UsasgeInstruction(medicationDtoCreate.getUsageInstruction()))
                .treatmentDuration(new TreatmentDuration(medicationDtoCreate.getTreatmentDuration()))
                .status(new Status(medicationDtoCreate.getStatus()))
                .medicalRecord(medicalRecord)
                .build();
    }
}
