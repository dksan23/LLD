package org.dksan.lld.parkinglot.service;

import org.dksan.lld.parkinglot.model.Car;
import org.dksan.lld.parkinglot.model.Slot;
import org.dksan.lld.parkinglot.strategy.parking.ParkingStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SlotManager {
    private final ParkingStrategy parkingStrategy;

    Integer totalSlots;
    HashMap<Integer, Slot> slots;

    HashMap<Integer, Slot> reservedSlots;

    public SlotManager(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        this.totalSlots = 0;
        slots = new HashMap<Integer, Slot>();
        reservedSlots = new HashMap<Integer, Slot>();
    }

    public SlotManager(int N, ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        this.totalSlots = N;
        slots = new HashMap<Integer, Slot>();
        reservedSlots = new HashMap<Integer, Slot>();
        initParkingStrategy();
    }

    private void initParkingStrategy()
    {
        for(int idx = 1; idx <= this.totalSlots; idx++)
        {
            parkingStrategy.addSlot(idx);
        }
    }


    public List<Integer> getSlotNumbersFromCarColor(String color) {

        List<Integer> result = new LinkedList<Integer>();
        for(Map.Entry<Integer, Slot> booking: reservedSlots.entrySet())
        {
                Slot slot = booking.getValue();
                Car car = slot.getParkedCar();
                if(car.getColor() == color)
                {
                    result.add(slot.getSlotNumber());
                }
        }
        return result;
    }

    public Integer getSlotNumberforCar(String registrationNumber) {
        for(Map.Entry<Integer, Slot> booking: reservedSlots.entrySet())
        {
            Slot slot = booking.getValue();
            Car car = slot.getParkedCar();
            if(car.getRegNo() == registrationNumber)
            {
                return slot.getSlotNumber();
            }
        }
        return -1;
    }

    public Slot reserveSlot(Car car) {
        int slotNumber = parkingStrategy.getNextFreeSlot();
        if(slotNumber != -1)
        {
            if(slots.containsKey(slotNumber) == false)
            {
                Slot slot  = new Slot(slotNumber);
                slot.setParkedCar(car);
                reservedSlots.put(slotNumber, slot);
                return slot;
            }
            else
            {
                Slot slot = slots.get(slotNumber);
                slot.setParkedCar(car);
                slots.remove(slotNumber);
                reservedSlots.put(slotNumber, slot);
                return slot;
            }
        }
        return null;
    }

    public void freeSlot(int slotNumber) {
        parkingStrategy.addSlot(slotNumber);
        Slot slot = reservedSlots.getOrDefault(slotNumber, null);
        if(slot != null)
        {
            reservedSlots.remove(slot.getSlotNumber());
            slot.unParkCar();
            slots.put(slot.getSlotNumber(), slot);
        }
    }

    public void addSlot(int slotNumber) {
        parkingStrategy.addSlot(slotNumber);
    }

    public void removeSlot(int slotNumber) {

        parkingStrategy.removeSlot(slotNumber);

        if(slots.getOrDefault(slotNumber, null) != null)
        {
            slots.remove(slotNumber);
        }
        else if(reservedSlots.getOrDefault(slotNumber, null) != null)
        {
            //todo throw exception
        }
    }
}
