package com.doctorya.Demo.domain.model.valueObjs;

import java.time.LocalDateTime;

public class DateTime {
    private final LocalDateTime value;

    public DateTime(LocalDateTime value){
        if (value == null){
            throw new IllegalArgumentException("The Date value cannot be Null");
        }
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }
}
