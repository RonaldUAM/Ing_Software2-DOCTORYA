package com.doctorya.Demo.domain.model.valueObjs;

public class DosageForm {
    private final String value;

    public DosageForm(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The DosageForm value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
