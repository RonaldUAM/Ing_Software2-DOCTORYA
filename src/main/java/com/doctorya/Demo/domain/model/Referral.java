package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Reason;

public class Referral {
    private final Id id;
    private final Date date;
    private final Reason reason;
    private final Doctor doctor;
    private final MedicalRecord medicalRecord;

    private Referral(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.doctor = builder.doctor;
        this.reason = builder.reason;
        this.medicalRecord = builder.medicalRecord;
    }

    public Id getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Reason getReason() {
        return reason;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public static class Builder extends AbstractBuilder<Referral>{
        private Id id;
        private Date date;
        private Reason reason;
        private Doctor doctor;
        private MedicalRecord medicalRecord;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder date(Date date){
            this.date = date;
            return this;
        }

        public Builder reason(Reason reason){
            this.reason = reason;
            return this;
        }

        public Builder doctor(Doctor doctor){
            this.doctor = doctor;
            return this;
        }

        public Builder medicalRecord(MedicalRecord medicalRecord){
            this.medicalRecord = medicalRecord;
            return this;
        }

        @Override
        public Referral build() {
            return new Referral(this);
        }
    }
}
