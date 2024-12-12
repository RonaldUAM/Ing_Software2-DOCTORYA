package com.doctorya.Demo.domain.model.valueObjs;

import java.time.LocalDate;

public class StartDate {
    private final LocalDate value;

    public StartDate(LocalDate value) {
        if (value == null){
            throw new IllegalArgumentException("The StartEnd value cannot be Null");
        }
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }
}
