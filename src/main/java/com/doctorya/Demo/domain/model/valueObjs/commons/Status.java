package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Status {
    private final String value;

    public Status(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Status value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
