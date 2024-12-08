package com.doctorya.Demo.domain.model.dto;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;

import java.io.Serializable;

public class DoctorDto implements Serializable {
    private Long id;
    private String name;
    private String identification;
    private String medicalLicense;
    private String speciality;
    private String email;
    private String phone;

    public DoctorDto() {
    }

    public DoctorDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.identification = builder.identification;
        this.medicalLicense = builder.medicalLicense;
        this.speciality = builder.speciality;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdentification() {
        return identification;
    }

    public String getMedicalLicense() {
        return medicalLicense;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder extends AbstractBuilder<DoctorDto>{
        private Long id;
        private String name;
        private String identification;
        private String medicalLicense;
        private String speciality;
        private String email;
        private String phone;

        public DoctorDto.Builder id(Long id){
            this.id = id;
            return this;
        }

        public DoctorDto.Builder name(String name){
            this.name = name;
            return this;
        }

        public DoctorDto.Builder identification(String identification){
            this.identification = identification;
            return this;
        }

        public DoctorDto.Builder medicalLicense(String medicalLicense){
            this.medicalLicense = medicalLicense;
            return this;
        }

        public DoctorDto.Builder speciality(String speciality){
            this.speciality = speciality;
            return this;
        }

        public DoctorDto.Builder email(String email){
            this.email = email;
            return this;
        }

        public DoctorDto.Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        @Override
        public DoctorDto build() {
            return new DoctorDto(this);
        }
    }
}
