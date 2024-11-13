package com.doctorya.Demo.domain.model.valueObjs;

public class InsuranceCoverage {
    private final Boolean value;

    public InsuranceCoverage(Boolean value) {
        if (value == null){
            throw new IllegalArgumentException("The Insurance Coverage value cannot be Null");
        }
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }
}
