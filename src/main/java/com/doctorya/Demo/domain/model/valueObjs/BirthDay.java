package com.doctorya.Demo.domain.model.valueObjs;

import java.time.LocalDate;

public class BirthDay {
    private final LocalDate value;

    public BirthDay(LocalDate value) {
        if (value == null){
            throw new IllegalArgumentException("The BirthDay value cannot be Null");
        }
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }
}
