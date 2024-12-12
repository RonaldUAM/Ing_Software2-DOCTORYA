package com.doctorya.Demo.domain.model.valueObjs;

public class Gender {
    private final String value;

    public Gender(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Gender value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
