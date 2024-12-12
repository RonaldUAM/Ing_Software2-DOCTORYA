package com.doctorya.Demo.domain.model.valueObjs;

public class Treatment {
    private final String value;

    public Treatment(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The treatment value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
