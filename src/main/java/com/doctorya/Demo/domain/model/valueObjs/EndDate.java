package com.doctorya.Demo.domain.model.valueObjs;

import java.time.LocalDate;

public class EndDate {
    private final LocalDate value;

    public EndDate(LocalDate value) {
        if (value == null){
            throw new IllegalArgumentException("The EndDate value cannot be Null");
        }
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }
}
