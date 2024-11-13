package com.doctorya.Demo.domain.model.valueObjs;

public class UsasgeInstruction {
    private final String value;

    public UsasgeInstruction(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The UsageInstruction value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
