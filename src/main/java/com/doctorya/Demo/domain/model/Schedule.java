package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.DateTime;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;

public class Schedule {
    private final Id id;
    private final DateTime date;
    private final Doctor doctor;

    private Schedule(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.doctor = builder.doctor;
    }

    public Id getId() {
        return id;
    }

    public DateTime getDate() {
        return date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public static class Builder extends AbstractBuilder<Schedule>{
        private Id id;
        private DateTime date;
        private Doctor doctor;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder date(DateTime date){
            this.date = date;
            return this;
        }

        public Builder doctor(Doctor doctor){
            this.doctor = doctor;
            return this;
        }

        @Override
        public Schedule build() {
            return new Schedule(this);
        }
    }
}
