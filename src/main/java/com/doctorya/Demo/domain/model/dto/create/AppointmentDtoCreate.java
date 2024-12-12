package com.doctorya.Demo.domain.model.dto.create;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDtoCreate implements Serializable {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    private String status;
    private Long patientId;
    private Long doctorId;

    public AppointmentDtoCreate() {
    }

    private AppointmentDtoCreate(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.time = builder.time;
        this.reason = builder.reason;
        this.status = builder.status;
        this.patientId = builder.patientId;
        this.doctorId = builder.doctorId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public Long getPatientDto() {
        return patientId;
    }

    public Long getDoctorDto() {
        return doctorId;
    }

    public static class Builder extends AbstractBuilder<AppointmentDtoCreate>{
        private Long id;
        private LocalDate date;
        private LocalTime time;
        private String reason;
        private String status;
        private Long patientId;
        private Long doctorId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder date(LocalDate date){
            this.date = date;
            return this;
        }

        public Builder time(LocalTime time){
            this.time = time;
            return this;
        }

        public Builder reason(String reason){
            this.reason = reason;
            return this;
        }

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder patientId(Long patientId){
            this.patientId = patientId;
            return this;
        }

        public Builder doctorId(Long doctorId){
            this.doctorId = doctorId;
            return this;
        }

        @Override
        public AppointmentDtoCreate build() {
            return new AppointmentDtoCreate(this);
        }
    }
}
