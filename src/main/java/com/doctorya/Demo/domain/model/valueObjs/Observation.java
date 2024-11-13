package com.doctorya.Demo.domain.model.valueObjs;

public class Observation {
    private final String value;

    public Observation(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Observation value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
