package com.doctorya.Demo.domain.model.valueObjs;

public class Type {
    private final String value;

    public Type(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Type value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
