package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.Observation;
import com.doctorya.Demo.domain.model.valueObjs.Symptoms;
import com.doctorya.Demo.domain.model.valueObjs.Treatment;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Diagnosis;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;

public class MedicalRecord {
    private final Id id;
    private final Date date;
    private final Symptoms symptoms;
    private final Diagnosis diagnosis;
    private final Treatment treatment;
    private final Observation observation;
    private final Appointment appointment;

    private MedicalRecord(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.symptoms = builder.symptoms;
        this.diagnosis = builder.diagnosis;
        this.treatment = builder.treatment;
        this.observation = builder.observation;
        this.appointment = builder.appointment;
    }

    public Id getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public Observation getObservation() {
        return observation;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public static class Builder extends AbstractBuilder<MedicalRecord>{
        private Id id;
        private Date date;
        private Symptoms symptoms;
        private Diagnosis diagnosis;
        private Treatment treatment;
        private Observation observation;
        private Appointment appointment;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder date(Date date){
            this.date = date;
            return this;
        }

        public Builder symptoms(Symptoms symptoms){
            this.symptoms = symptoms;
            return this;
        }

        public Builder diagnosis(Diagnosis diagnosis){
            this.diagnosis = diagnosis;
            return this;
        }

        public Builder treatment(Treatment treatment){
            this.treatment = treatment;
            return this;
        }

        public Builder observation(Observation observation){
            this.observation = observation;
            return this;
        }

        public Builder appointment(Appointment appointment){
            this.appointment = appointment;
            return this;
        }


        @Override
        public MedicalRecord build() {
            return new MedicalRecord(this);
        }
    }
}
