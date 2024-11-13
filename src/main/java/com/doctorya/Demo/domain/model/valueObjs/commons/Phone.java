package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Phone {
    private final String value;

    public Phone(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Phone value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
