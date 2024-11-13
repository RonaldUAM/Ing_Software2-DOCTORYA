package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.Cost;
import com.doctorya.Demo.domain.model.valueObjs.InsuranceCoverage;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;
import com.doctorya.Demo.domain.model.valueObjs.commons.Status;

public class Test {
    private final Id id;
    private final Name name;
    private final Cost cost;
    private final InsuranceCoverage insuranceCoverage;
    private final Status status;
    private final MedicalRecord medicalRecord;

    private Test(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.cost = builder.cost;
        this.insuranceCoverage = builder.insuranceCoverage;
        this.status = builder.status;
        this.medicalRecord = builder.medicalRecord;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Cost getCost() {
        return cost;
    }

    public InsuranceCoverage getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public Status getStatus() {
        return status;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public static class Builder extends AbstractBuilder<Test>{
        private Id id;
        private Name name;
        private Cost cost;
        private InsuranceCoverage insuranceCoverage;
        private Status status;
        private MedicalRecord medicalRecord;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder cost(Cost cost){
            this.cost = cost;
            return this;
        }

        public Builder insuranceCoverage(InsuranceCoverage insuranceCoverage){
            this.insuranceCoverage = insuranceCoverage;
            return this;
        }

        public Builder status(Status status){
            this.status = status;
            return this;
        }

        public Builder medicalRecord(MedicalRecord medicalRecord){
            this.medicalRecord = medicalRecord;
            return this;
        }

        @Override
        public Test build() {
            return new Test(this);
        }
    }
}
