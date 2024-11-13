package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.Address;
import com.doctorya.Demo.domain.model.valueObjs.BirthDay;
import com.doctorya.Demo.domain.model.valueObjs.Gender;
import com.doctorya.Demo.domain.model.valueObjs.commons.*;

public class Patient {
    private final Id id;
    private final Name name;
    private final Identification identification;
    private final BirthDay birthDay;
    private final Gender gender;
    private final Address address;
    private final Email email;
    private final Phone phone;
    private final MedicalInsurance insurance;

    private Patient(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.birthDay = builder.birthDay;
        this.gender = builder.gender;
        this.address = builder.address;
        this.email = builder.email;
        this.phone = builder.phone;
        this.insurance = builder.insurance;
        this.identification = builder.identification;
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

    public BirthDay getBirthDay() {
        return birthDay;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public Email getEmail() {
        return email;
    }

    public Phone getPhone() {
        return phone;
    }

    public MedicalInsurance getInsurance() {
        return insurance;
    }

    public static class Builder extends AbstractBuilder<Patient>{
        private Id id;
        private Name name;
        private Identification identification;
        private BirthDay birthDay;
        private Gender gender;
        private Address address;
        private Email email;
        private Phone phone;
        private MedicalInsurance insurance;

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

        public Builder birthDay(BirthDay birthDay){
            this.birthDay = birthDay;
            return this;
        }

        public Builder gender(Gender gender){
            this.gender = gender;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public Builder email(Email email){
            this.email = email;
            return this;
        }

        public Builder phone(Phone phone){
            this.phone = phone;
            return this;
        }

        public Builder medicalInsurance(MedicalInsurance medicalInsurance){
            this.insurance = medicalInsurance;
            return this;
        }

        @Override
        public Patient build() {
            return new Patient(this);
        }
    }
}
