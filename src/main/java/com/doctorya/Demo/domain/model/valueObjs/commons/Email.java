package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Email {
    private final String value;

    public Email(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Email value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
