package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Name {
    private String value;

    public Name(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The Name value  be Null");
        }else if(value.equals(".")){
            this.value = "";
        }else{
            this.value = value;
        }
    }

    public String getvalue() {
        return value;
    }
}
