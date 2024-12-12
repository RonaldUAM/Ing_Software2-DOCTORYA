package com.doctorya.Demo.domain.model.valueObjs;

public class TreatmentDuration {
    private final String value;

    public TreatmentDuration(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The TreatmentDuration value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
