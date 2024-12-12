package com.doctorya.Demo.domain.model.valueObjs;

import java.time.LocalTime;

public class Time {
    private final LocalTime value;

    public Time(LocalTime value) {
        if (value == null || value.equals(LocalTime.of(0,0,0))){
            throw new IllegalArgumentException("The Time value cannot be Null");
        }
        this.value = value;
    }

    public LocalTime getValue() {
        return value;
    }
}
