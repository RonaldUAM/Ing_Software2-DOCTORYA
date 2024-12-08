package com.doctorya.Demo.domain.model.dto;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto implements Serializable {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    private String status;
    private PatientDto patientDto;
    private DoctorDto doctorDto;

    public AppointmentDto() {
    }

    private AppointmentDto(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.time = builder.time;
        this.reason = builder.reason;
        this.status = builder.status;
        this.patientDto = builder.patientDto;
        this.doctorDto = builder.doctorDto;
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

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public DoctorDto getDoctorDto() {
        return doctorDto;
    }

    public static class Builder extends AbstractBuilder<AppointmentDto>{
        private Long id;
        private LocalDate date;
        private LocalTime time;
        private String reason;
        private String status;
        private PatientDto patientDto;
        private DoctorDto doctorDto;

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

        public Builder patientDto(PatientDto patientDto){
            this.patientDto = patientDto;
            return this;
        }

        public Builder doctorDto(DoctorDto doctorDto){
            this.doctorDto = doctorDto;
            return this;
        }

        @Override
        public AppointmentDto build() {
            return new AppointmentDto(this);
        }
    }
}
