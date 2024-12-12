package com.doctorya.Demo.domain.model.dto.create;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ScheduleDtoCreate implements Serializable {
    private Long id;
    private LocalDateTime date;
    private Long doctorId;

    public ScheduleDtoCreate(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.doctorId = builder.doctorId;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorDto(Long doctorId) {
        this.doctorId = doctorId;
    }

    public static class Builder extends AbstractBuilder<ScheduleDtoCreate>{
        private Long id;
        private LocalDateTime date;
        private Long doctorId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder date(LocalDateTime date){
            this.date = date;
            return this;
        }

        public Builder doctor(Long doctorId){
            this.doctorId = doctorId;
            return this;
        }

        @Override
        public ScheduleDtoCreate build() {
            return new ScheduleDtoCreate(this);
        }
    }
}

