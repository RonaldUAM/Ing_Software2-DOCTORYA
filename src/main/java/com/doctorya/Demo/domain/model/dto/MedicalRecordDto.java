package com.doctorya.Demo.domain.model.dto;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalRecordDto implements Serializable {
    private Long id;
    private LocalDate date;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String observations;
    private AppointmentDto appointmentDto;

    public MedicalRecordDto() {
    }

    private MedicalRecordDto(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.symptoms = builder.symptoms;
        this.diagnosis = builder.diagnosis;
        this.treatment = builder.treatment;
        this.observations = builder.observations;
        this.appointmentDto = builder.appointmentDto;
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

    public AppointmentDto getAppointmentDto() {
        return appointmentDto;
    }

    public static class Builder extends AbstractBuilder<MedicalRecordDto>{

        private Long id;
        private LocalDate date;
        private String symptoms;
        private String diagnosis;
        private String treatment;
        private String observations;
        private AppointmentDto appointmentDto;

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

        public Builder appointment(AppointmentDto appointmentDto){
            this.appointmentDto = appointmentDto;
            return this;
        }

        @Override
        public MedicalRecordDto build() {
            return new MedicalRecordDto(this);
        }
    }
}
