package com.doctorya.Demo.domain.model.valueObjs;

public class ContactPhone {
    private final String value;

    public ContactPhone(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The ContactPhone value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
