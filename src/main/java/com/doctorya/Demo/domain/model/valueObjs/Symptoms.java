package com.doctorya.Demo.domain.model.valueObjs;

public class Symptoms {
    private final String value;

    public Symptoms(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Symptoms value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
