package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.*;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;
import com.doctorya.Demo.domain.model.valueObjs.commons.Status;

public class Medication {
    private final Id id;
    private final Name name;
    private final ActiveIngredient activeIngredient;
    private final DosageForm dosageForm;
    private final Dosage dosage;
    private final UsasgeInstruction usasgeInstruction;
    private final TreatmentDuration treatmentDuration;
    private final Status status;
    private final MedicalRecord medicalRecord;

    private Medication(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.activeIngredient = builder.activeIngredient;
        this.dosageForm = builder.dosageForm;
        this.dosage = builder.dosage;
        this.usasgeInstruction = builder.usasgeInstruction;
        this.treatmentDuration = builder.treatmentDuration;
        this.status = builder.status;
        this.medicalRecord = builder.medicalRecord;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public ActiveIngredient getActiveIngredient() {
        return activeIngredient;
    }

    public DosageForm getDosageForm() {
        return dosageForm;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public UsasgeInstruction getUsasgeInstruction() {
        return usasgeInstruction;
    }

    public TreatmentDuration getTreatmentDuration() {
        return treatmentDuration;
    }

    public Status getStatus() {
        return status;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public static class Builder extends AbstractBuilder<Medication>{
        private Id id;
        private Name name;
        private ActiveIngredient activeIngredient;
        private DosageForm dosageForm;
        private Dosage dosage;
        private UsasgeInstruction usasgeInstruction;
        private TreatmentDuration treatmentDuration;
        private Status status;
        private MedicalRecord medicalRecord;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder activeIngredient(ActiveIngredient activeIngredient){
            this.activeIngredient = activeIngredient;
            return this;
        }

        public Builder dosageForm(DosageForm dosageForm){
            this.dosageForm = dosageForm;
            return this;
        }

        public Builder dosage(Dosage dosage){
            this.dosage = dosage;
            return this;
        }

        public Builder usasgeInstruction(UsasgeInstruction usasgeInstruction){
            this.usasgeInstruction = usasgeInstruction;
            return this;
        }

        public Builder treatmentDuration(TreatmentDuration treatmentDuration){
            this.treatmentDuration = treatmentDuration;
            return this;
        }

        public Builder status(Status status){
            this.status = status;
            return this;
        }

        public Builder medicalRecord(MedicalRecord medicalRecord){
            this.medicalRecord = medicalRecord;
            return this;
        }

        @Override
        public Medication build() {
            return new Medication(this);
        }
    }
}
