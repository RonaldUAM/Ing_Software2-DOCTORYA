package com.doctorya.Demo.domain.model.valueObjs.commons;

public class Name {
    private final String nvalue;

    public Name(String nvalue) {
        if (nvalue.isBlank()){
            throw new IllegalArgumentException("The Name value cannot be Null");
        }
        this.nvalue = nvalue;
    }

    public String getvalue() {
        return nvalue;
    }
}
