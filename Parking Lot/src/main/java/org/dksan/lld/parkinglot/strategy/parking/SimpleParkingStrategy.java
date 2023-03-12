package org.dksan.lld.parkinglot.strategy.parking;

import org.dksan.lld.parkinglot.exception.NoSlotsException;

import java.util.PriorityQueue;

public class SimpleParkingStrategy implements ParkingStrategy{

    PriorityQueue<Integer> slots;

    public SimpleParkingStrategy(PriorityQueue<Integer> slots) {
        this.slots = slots;
    }

    public SimpleParkingStrategy(int N) {
        slots = new PriorityQueue<Integer>();
    }

    public SimpleParkingStrategy() {
        slots = new PriorityQueue<Integer>();
    }
    @Override
    public void addSlot(int slotNumber) {
        slots.add(slotNumber);
    }

    @Override
    public int getNextFreeSlot() throws NoSlotsException {
        if(slots.isEmpty())
        {
            throw new NoSlotsException("No Slots available");
        }
        else
        {
            return slots.poll();
        }
    }

    @Override
    public void removeSlot(int slotNumber) {
        slots.remove(slotNumber);
    }
}
