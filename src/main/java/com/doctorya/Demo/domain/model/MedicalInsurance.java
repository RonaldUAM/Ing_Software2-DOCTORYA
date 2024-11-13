package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.ContactPhone;
import com.doctorya.Demo.domain.model.valueObjs.EndDate;
import com.doctorya.Demo.domain.model.valueObjs.StartDate;
import com.doctorya.Demo.domain.model.valueObjs.Type;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;
import com.doctorya.Demo.domain.model.valueObjs.commons.Name;

public class MedicalInsurance {
    private final Id id;
    private final Name name;
    private final Type type;
    private final StartDate startDate;
    private final EndDate endDate;
    private final ContactPhone contactPhone;

    private MedicalInsurance(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.contactPhone = builder.contactPhone;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public ContactPhone getContactPhone() {
        return contactPhone;
    }

    public static class Builder extends AbstractBuilder<MedicalInsurance>{
        private Id id;
        private Name name;
        private Type type;
        private StartDate startDate;
        private EndDate endDate;
        private ContactPhone contactPhone;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder type(Type type){
            this.type = type;
            return this;
        }

        public Builder startDate(StartDate startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(EndDate endDate){
            this.endDate = endDate;
            return this;
        }

        public Builder contactPhone(ContactPhone contactPhone){
            this.contactPhone = contactPhone;
            return this;
        }


        @Override
        public MedicalInsurance build() {
            return new MedicalInsurance(this);
        }
    }
}
