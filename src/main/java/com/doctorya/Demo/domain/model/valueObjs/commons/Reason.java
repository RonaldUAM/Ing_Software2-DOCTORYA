package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Reason {
    private final String value;

    public Reason(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Reason value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
