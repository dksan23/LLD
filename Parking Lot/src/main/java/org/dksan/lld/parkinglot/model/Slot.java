package org.dksan.lld.parkinglot.model;

public class Slot {
    Car parkedCar;
    int slotNumber;

    public Car getParkedCar() {
        return parkedCar;
    }

    public Car unParkCar()
    {
        Car car = this.parkedCar;
        this.parkedCar = null;
        return car;
    }

    public void setParkedCar(Car parkedCar) {
        this.parkedCar = parkedCar;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Slot(Car parkedCar, int slotNumber) {
        this.parkedCar = parkedCar;
        this.slotNumber = slotNumber;
    }

    public Slot(int slotNumber) {
        this.parkedCar = null;
        this.slotNumber = slotNumber;
    }
}
