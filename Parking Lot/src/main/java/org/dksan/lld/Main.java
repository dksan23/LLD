package org.dksan.lld;

import org.dksan.lld.parkinglot.model.Slot;
import org.dksan.lld.parkinglot.service.ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(20);
        int slotNumber = parkingLot.reserveSlot("Blue", "XYZ-ABC");
        System.out.println("Reserved Slot Number :"+ slotNumber);
        int slot2 = parkingLot.reserveSlot("Blue", "HGH-IHI");
        System.out.println("Reserved Slot Number :"+ slot2);
        parkingLot.freeSlot(slotNumber);
        slot2 = parkingLot.reserveSlot("Blue", "PJF-QWE");
        System.out.println("Reserved Slot Number :"+ slot2);
        parkingLot.freeSlot(slot2);
    }
}