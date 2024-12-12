package com.doctorya.Demo.domain.model.valueObjs;

public class Dosage {
    private final String value;

    public Dosage(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Dosage value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
