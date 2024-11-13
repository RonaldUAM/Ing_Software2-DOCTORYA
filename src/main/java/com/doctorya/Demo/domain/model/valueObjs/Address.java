package com.doctorya.Demo.domain.model.valueObjs;

public class Address {
    private final String value;

    public Address(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Address value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
