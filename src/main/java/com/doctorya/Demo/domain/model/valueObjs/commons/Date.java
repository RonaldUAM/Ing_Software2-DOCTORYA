package com.doctorya.Demo.domain.model.valueObjs.commons;

import java.time.LocalDate;

public class Date {
    private final LocalDate value;

    public Date(LocalDate value){
        if (value == null){
            throw new IllegalArgumentException("The Date value cannot be Null");
        }
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }
}
