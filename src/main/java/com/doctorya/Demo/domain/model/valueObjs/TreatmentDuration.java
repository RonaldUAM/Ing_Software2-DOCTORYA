package com.doctorya.Demo.domain.model.valueObjs;

public class TreatmentDuration {
    private final Integer value;

    public TreatmentDuration(Integer value) {
        if (value.equals(0) || value != null ){
            throw new IllegalArgumentException("The TreatmentDuration value cannot be Null");
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
