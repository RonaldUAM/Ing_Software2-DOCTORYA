package com.doctorya.Demo.domain.model.valueObjs;

public class Specialty {
    private final String value;

    public Specialty(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Specialty value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
