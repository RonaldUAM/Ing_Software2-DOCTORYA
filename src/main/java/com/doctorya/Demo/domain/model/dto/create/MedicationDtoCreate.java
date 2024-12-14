package com.doctorya.Demo.domain.model.dto.create;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import java.io.Serializable;
import java.time.LocalDate;

public class MedicationDtoCreate implements Serializable {
    private Long id;
    private String name;
    private String activeIngredient;
    private String dosageForm;
    private String dosage;
    private String usageInstruction;
    private String treatmentDuration;
    private String status;
    private Long medicalRecordId;

    public MedicationDtoCreate() {
    }

    private MedicationDtoCreate(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.activeIngredient = builder.activeIngredient;
        this.dosageForm = builder.dosageForm;
        this.dosage = builder.dosage;
        this.usageInstruction = builder.usageInstruction;
        this.treatmentDuration = builder.treatmentDuration;
        this.status = builder.status;
        this.medicalRecordId = builder.medicalRecordId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public String getDosage() {
        return dosage;
    }

    public String getUsageInstruction() {
        return usageInstruction;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }

    public String getStatus() {
        return status;
    }

    public Long getMedicalRecordId() {
        return medicalRecordId;
    }

    public static class Builder extends AbstractBuilder<MedicationDtoCreate> {
        private Long id;
        private String name;
        private String activeIngredient;
        private String dosageForm;
        private String dosage;
        private String usageInstruction;
        private String treatmentDuration;
        private String status;
        private Long medicalRecordId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder activeIngredient(String activeIngredient) {
            this.activeIngredient = activeIngredient;
            return this;
        }

        public Builder dosageForm(String dosageForm) {
            this.dosageForm = dosageForm;
            return this;
        }

        public Builder dosage(String dosage) {
            this.dosage = dosage;
            return this;
        }

        public Builder usageInstruction(String usageInstruction) {
            this.usageInstruction = usageInstruction;
            return this;
        }

        public Builder treatmentDuration(String treatmentDuration) {
            this.treatmentDuration = treatmentDuration;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder medicalRecord(Long medicalRecordId) {
            this.medicalRecordId = medicalRecordId;
            return this;
        }

        @Override
        public MedicationDtoCreate build() {
            return new MedicationDtoCreate(this);
        }
    }
}
