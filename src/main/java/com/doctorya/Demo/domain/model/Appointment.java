package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.Time;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Reason;
import com.doctorya.Demo.domain.model.valueObjs.commons.Status;

public class Appointment {
    private final Id id;
    private final Date date;
    private final Time time;
    private final Reason reason;
    private final Status status;
    private final Patient patient;
    private final Doctor doctor;

    private Appointment(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.time = builder.time;
        this.reason = builder.reason;
        this.status = builder.status;
        this.patient = builder.patient;
        this.doctor = builder.doctor;
    }

    public Id getId() { return id; }
    public Date getDate() { return date; }
    public Time getTime() { return time; }
    public Reason getReason() { return reason; }
    public Status getStatus() { return status; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    public static class Builder extends AbstractBuilder<Appointment> {
        private Id id;
        private Date date;
        private Time time;
        private Reason reason;
        private Status status;
        private Patient patient;
        private Doctor doctor;

        public Builder id(Id id) {
            this.id = id;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder time(Time time) {
            this.time = time;
            return this;
        }

        public Builder reason(Reason reason) {
            this.reason = reason;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder patient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        @Override
        public Appointment build() {
            return new Appointment(this);
        }
    }
}
