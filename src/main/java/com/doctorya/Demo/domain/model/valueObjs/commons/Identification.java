package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Identification {
    private final String value;

    public Identification(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Identification value cannot be Null");
        }else if(value.equals(".")){
            this.value = "";
        }else{
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }
}
