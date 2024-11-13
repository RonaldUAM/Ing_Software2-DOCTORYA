package com.doctorya.Demo.domain.model.valueObjs;

public class Content {
    private final String value;

    public Content(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Content value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
