package com.doctorya.Demo.domain.model.dto.search;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalRecordDtoFind implements Serializable {
    private Long id;
    private LocalDate date;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String observations;
    private AppointmentDtoFind appointmentDtoFind;

    public MedicalRecordDtoFind() {
    }

    private MedicalRecordDtoFind(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.symptoms = builder.symptoms;
        this.diagnosis = builder.diagnosis;
        this.treatment = builder.treatment;
        this.observations = builder.observations;
        this.appointmentDtoFind = builder.appointmentDtoFind;
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

    public AppointmentDtoFind getAppointmentDto() {
        return appointmentDtoFind;
    }

    public static class Builder extends AbstractBuilder<MedicalRecordDtoFind>{

        private Long id;
        private LocalDate date;
        private String symptoms;
        private String diagnosis;
        private String treatment;
        private String observations;
        private AppointmentDtoFind appointmentDtoFind;

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

        public Builder appointment(AppointmentDtoFind appointmentDtoFind){
            this.appointmentDtoFind = appointmentDtoFind;
            return this;
        }

        @Override
        public MedicalRecordDtoFind build() {
            return new MedicalRecordDtoFind(this);
        }
    }
}
