package com.doctorya.Demo.domain.model.valueObjs;

public class MedicalLicense {
    private final String value;

    public MedicalLicense(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The MedicalLicense value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
