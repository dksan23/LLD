package org.dksan.lld.parkinglot.model;

import java.util.Objects;

public class Car {
    String color;

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return regNo.equals(car.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    String regNo;

    public Car(String color, String regNo) {
        this.color = color;
        this.regNo = regNo;
    }
}
