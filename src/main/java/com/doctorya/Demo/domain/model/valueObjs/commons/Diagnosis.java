package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Diagnosis {
    private final String value;

    public Diagnosis(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Diagnosis value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
