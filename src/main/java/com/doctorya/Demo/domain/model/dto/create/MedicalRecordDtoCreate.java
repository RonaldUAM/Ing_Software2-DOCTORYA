package com.doctorya.Demo.domain.model.dto.create;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.dto.search.AppointmentDtoFind;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalRecordDtoCreate implements Serializable {
    private Long id;
    private LocalDate date;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String observations;
    private Long appointmentId;

    public MedicalRecordDtoCreate() {
    }

    private MedicalRecordDtoCreate(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.symptoms = builder.symptoms;
        this.diagnosis = builder.diagnosis;
        this.treatment = builder.treatment;
        this.observations = builder.observations;
        this.appointmentId = builder.appointmentId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getObservations() {
        return observations;
    }

    public Long getAppointmentDto() {
        return appointmentId;
    }

    public static class Builder extends AbstractBuilder<MedicalRecordDtoCreate>{

        private Long id;
        private LocalDate date;
        private String symptoms;
        private String diagnosis;
        private String treatment;
        private String observations;
        private Long appointmentId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder date(LocalDate date){
            this.date = date;
            return this;
        }

        public Builder symptoms(String symptoms){
            this.symptoms = symptoms;
            return this;
        }

        public Builder diagnosis(String diagnosis){
            this.diagnosis = diagnosis;
            return this;
        }

        public Builder treatment(String treatment){
            this.treatment = treatment;
            return this;
        }

        public Builder observations(String observations){
            this.observations = observations;
            return this;
        }

        public Builder appointment(Long appointmentId){
            this.appointmentId = appointmentId;
            return this;
        }

        @Override
        public MedicalRecordDtoCreate build() {
            return new MedicalRecordDtoCreate(this);
        }
    }
}
