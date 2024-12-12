package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.PossibleTreatment;
import com.doctorya.Demo.domain.model.valueObjs.commons.Diagnosis;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;

public class TestResult {
    private final Id id;
    private final Diagnosis diagnosis;
    private final PossibleTreatment possibleTreatment;
    private final Test test;
    private final Doctor doctor;

    private TestResult(Builder builder) {
        this.id = builder.id;
        this.diagnosis = builder.diagnosis;
        this.possibleTreatment = builder.possibleTreatment;
        this.test = builder.test;
        this.doctor = builder.doctor;
    }

    public Id getId() {
        return id;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public PossibleTreatment getPossibleTreatment() {
        return possibleTreatment;
    }

    public Test getTest() {
        return test;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public static class Builder extends AbstractBuilder<TestResult>{
        private Id id;
        private Diagnosis diagnosis;
        private PossibleTreatment possibleTreatment;
        private Test test;
        private Doctor doctor;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder diagnosis(Diagnosis diagnosis){
            this.diagnosis = diagnosis;
            return this;
        }

        public Builder possibleTreatment(PossibleTreatment possibleTreatment){
            this.possibleTreatment = possibleTreatment;
            return this;
        }

        public Builder test(Test test){
            this.test = test;
            return this;
        }

        public Builder doctor(Doctor doctor){
            this.doctor = doctor;
            return this;
        }

        @Override
        public TestResult build() {
            return new TestResult(this);
        }
    }
}
