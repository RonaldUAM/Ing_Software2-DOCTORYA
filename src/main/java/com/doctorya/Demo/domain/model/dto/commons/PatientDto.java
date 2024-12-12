package com.doctorya.Demo.domain.model.dto.commons;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;

import java.io.Serializable;
import java.time.LocalDate;

public class PatientDto implements Serializable {
    private Long id;
    private String name;
    private String identification;
    private LocalDate birthDay;
    private String gender;
    private String address;
    private String email;
    private String phone;
    private MedicalInsuranceDto insurance;

    public PatientDto() {
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public MedicalInsuranceDto getInsurance() {
        return insurance;
    }

    public void setInsurance(MedicalInsuranceDto insurance) {
        this.insurance = insurance;
    }

    private PatientDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.identification = builder.identification;
        this.birthDay = builder.birthDay;
        this.gender = builder.gender;
        this.address = builder.address;
        this.email = builder.email;
        this.phone = builder.phone;
        this.insurance = builder.insurance;

    }

    public static class Builder extends AbstractBuilder<PatientDto>{
        private Long id;
        private String name;
        private String identification;
        private LocalDate birthDay;
        private String gender;
        private String address;
        private String email;
        private String phone;
        private MedicalInsuranceDto insurance;

        public PatientDto.Builder id(Long id){
            this.id = id;
            return this;
        }

        public PatientDto.Builder name(String name){
            this.name = name;
            return this;
        }

        public PatientDto.Builder identification(String identification){
            this.identification = identification;
            return this;
        }

        public PatientDto.Builder birthDay(LocalDate birthDay){
            this.birthDay = birthDay;
            return this;
        }

        public PatientDto.Builder gender(String gender){
            this.gender = gender;
            return this;
        }

        public PatientDto.Builder address(String address){
            this.address = address;
            return this;
        }

        public PatientDto.Builder email(String email){
            this.email = email;
            return this;
        }

        public PatientDto.Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public PatientDto.Builder insurance(MedicalInsuranceDto insurance){
            this.insurance = insurance;
            return this;
        }

        @Override
        public PatientDto build() {
            return new PatientDto(this);
        }
    }
}
