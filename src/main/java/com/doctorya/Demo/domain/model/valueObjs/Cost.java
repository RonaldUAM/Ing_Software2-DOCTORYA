package com.doctorya.Demo.domain.model.valueObjs;

public class Cost {
    private final double value;

    public Cost(double value) {
        if (value == 0){
            throw new IllegalArgumentException("The Cost value cannot be Null");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
