package com.doctorya.Demo.domain.model.valueObjs;

public class Time {
    private final Integer value;

    public Time(Integer value) {
        if (value == null || value.equals(0)){
            throw new IllegalArgumentException("The Time value cannot be Null");
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
