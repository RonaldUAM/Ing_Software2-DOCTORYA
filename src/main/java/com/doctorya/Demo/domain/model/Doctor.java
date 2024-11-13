package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.MedicalLicense;
import com.doctorya.Demo.domain.model.valueObjs.Specialty;
import com.doctorya.Demo.domain.model.valueObjs.commons.*;

public class Doctor {
    private final Id id;
    private final Name name;
    private final Identification identification;
    private final MedicalLicense medicalLicense;
    private final Specialty specialty;
    private final Email emaill;
    private final Phone phone;

    private Doctor(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.identification = builder.identification;
        this.medicalLicense = builder.medicalLicense;
        this.specialty = builder.specialty;
        this.emaill = builder.emaill;
        this.phone = builder.phone;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Identification getIdentification() {
        return identification;
    }

    public MedicalLicense getMedicalLicense() {
        return medicalLicense;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public Email getEmaill() {
        return emaill;
    }

    public Phone getPhone() {
        return phone;
    }

    public static class Builder extends AbstractBuilder<Doctor> {
        private Id id;
        private Name name;
        private Identification identification;
        private MedicalLicense medicalLicense;
        private Specialty specialty;
        private Email emaill;
        private Phone phone;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder identification(Identification identification){
            this.identification = identification;
            return this;
        }

        public Builder medicalLicense(MedicalLicense medicalLicense){
            this.medicalLicense = medicalLicense;
            return this;
        }

        public Builder specialty(Specialty specialty){
            this.specialty = specialty;
            return this;
        }

        public Builder email(Email email){
            this.emaill = email;
            return this;
        }

        public Builder phone(Phone phone){
            this.phone = phone;
            return this;
        }

        @Override
        public Doctor build() {
            return new Doctor(this);
        }
    }

}
