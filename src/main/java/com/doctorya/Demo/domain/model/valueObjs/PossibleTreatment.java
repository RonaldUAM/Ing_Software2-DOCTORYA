package com.doctorya.Demo.domain.model.valueObjs;

public class PossibleTreatment {
    private final String value;

    public PossibleTreatment(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The PossibleTreatment value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
