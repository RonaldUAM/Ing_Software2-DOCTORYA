package com.doctorya.Demo.domain.model.valueObjs;

public class ActiveIngredient {
    private final String value;

    public ActiveIngredient(String value) {
        if (value.isBlank()){
            throw new IllegalArgumentException("The ActiveIngredient value cannot be Null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
