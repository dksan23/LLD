package org.dksan.lld.parkinglot.strategy.parking;

public interface ParkingStrategy {

    public void addSlot(int slotNumber);

    public int getNextFreeSlot();

    public void removeSlot(int slotNumber);
}
