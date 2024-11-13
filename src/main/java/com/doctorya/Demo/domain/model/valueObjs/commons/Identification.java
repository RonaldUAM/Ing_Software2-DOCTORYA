package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Identification {
    private final String value;

    public Identification(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Identification value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
