package com.doctorya.Demo.domain.model.dto.search;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.dto.commons.DoctorDto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ScheduleDtoFind implements Serializable {
    private Long id;
    private LocalDateTime date;
    private DoctorDto doctorDto;

    public ScheduleDtoFind(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.doctorDto = builder.doctorDto;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public DoctorDto getDoctorDto() {
        return doctorDto;
    }

    public void setDoctorDto(DoctorDto doctorDto) {
        this.doctorDto = doctorDto;
    }

    public static class Builder extends AbstractBuilder<ScheduleDtoFind>{
        private Long id;
        private LocalDateTime date;
        private DoctorDto doctorDto;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder date(LocalDateTime date){
            this.date = date;
            return this;
        }

        public Builder doctor(DoctorDto doctorDto){
            this.doctorDto = doctorDto;
            return this;
        }

        @Override
        public ScheduleDtoFind build() {
            return new ScheduleDtoFind(this);
        }
    }
}

