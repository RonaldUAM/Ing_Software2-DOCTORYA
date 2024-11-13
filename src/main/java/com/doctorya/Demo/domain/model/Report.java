package com.doctorya.Demo.domain.model;

import com.doctorya.Demo.domain.model.buildModel.AbstractBuilder;
import com.doctorya.Demo.domain.model.valueObjs.Content;
import com.doctorya.Demo.domain.model.valueObjs.Type;
import com.doctorya.Demo.domain.model.valueObjs.commons.Date;
import com.doctorya.Demo.domain.model.valueObjs.commons.Id;

public class Report {
    private final Id id;
    private final Date date;
    private final Type type;
    private final Content content;

    private Report(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.type = builder.type;
        this.content = builder.content;
    }

    public Id getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    public Content getContent() {
        return content;
    }

    public static class Builder extends AbstractBuilder<Report>{
        private Id id;
        private Date date;
        private Type type;
        private Content content;

        public Builder id(Id id){
            this.id = id;
            return this;
        }

        public Builder date(Date date){
            this.date = date;
            return this;
        }

        public Builder type(Type type){
            this.type = type;
            return this;
        }

        public Builder content(Content content){
            this.content = content;
            return this;
        }

        @Override
        public Report build() {
            return new Report(this);
        }
    }
}
