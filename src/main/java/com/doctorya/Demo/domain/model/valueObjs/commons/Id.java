package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Id {
    private final Long value;

    public Id(Long value) {
        if (value == null){
            throw new IllegalArgumentException("The Id value cannot be Null");
        }
        this.value = value;

    }

    public Long getValue() {
        return value;
    }
}
