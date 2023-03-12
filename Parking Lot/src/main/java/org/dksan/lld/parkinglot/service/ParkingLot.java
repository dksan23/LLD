package org.dksan.lld.parkinglot.service;

import org.dksan.lld.parkinglot.exception.InvalidParkingStrategyException;
import org.dksan.lld.parkinglot.model.Car;
import org.dksan.lld.parkinglot.model.ParkingStrategyType;
import org.dksan.lld.parkinglot.model.Slot;
import org.dksan.lld.parkinglot.strategy.parking.ParkingStrategy;
import org.dksan.lld.parkinglot.strategy.parking.SimpleParkingStrategy;

import java.util.List;

public class ParkingLot {
    private final CarManager carManager;
    private final SlotManager slotManager;

    private final ParkingStrategy parkingStrategy;

    public ParkingLot() {
        carManager = new CarManager();
        parkingStrategy = getParkingStrategyFromType(ParkingStrategyType.SIMPLE_PARKING_STRATEGY);
        slotManager = new SlotManager(parkingStrategy);
    }

    public ParkingLot(ParkingStrategyType parkingStrategyType) {
        carManager = new CarManager();
        parkingStrategy = getParkingStrategyFromType(parkingStrategyType);
        slotManager = new SlotManager(parkingStrategy);
    }

    public ParkingLot(int N, ParkingStrategyType parkingStrategyType)
    {
        carManager = new CarManager();
        parkingStrategy = getParkingStrategyFromType(parkingStrategyType);
        slotManager = new SlotManager(N, parkingStrategy);
    }

    public ParkingLot(int N)
    {
        carManager = new CarManager();
        parkingStrategy = getParkingStrategyFromType(ParkingStrategyType.SIMPLE_PARKING_STRATEGY);
        slotManager = new SlotManager(N, parkingStrategy);
    }

    private ParkingStrategy getParkingStrategyFromType(ParkingStrategyType parkingStrategyType)
    {
        switch(parkingStrategyType){
            case SIMPLE_PARKING_STRATEGY :
                return new SimpleParkingStrategy();
            default:
            {
                throw new InvalidParkingStrategyException("Unrecognized Parking Strategy Specified while creating parking lot");
            }
        }
    }

    public List<Integer> slotNumberFromCarColor(String color)
    {
        return slotManager.getSlotNumbersFromCarColor(color);
    }

    public Integer slotNumberFromCarRegistrationNumber(String registrationNumber)
    {
        return slotManager.getSlotNumberforCar(registrationNumber);
    }

    public int reserveSlot(String color, String regNumber)
    {
        Car car  = new Car(color, regNumber);
        Slot reservedSlot = slotManager.reserveSlot(car);
        if(reservedSlot != null)
        {
            carManager.addCar(car);
            return reservedSlot.getSlotNumber();
        }
        return -1;
    }

    public void freeSlot(int slotNumber)
    {
        slotManager.freeSlot(slotNumber);
    }

    public void addSlot(int slotNumber)
    {
        slotManager.addSlot(slotNumber);
    }

    public void removeSlot(int slotNumber)
    {
        slotManager.removeSlot(slotNumber);
    }
}
