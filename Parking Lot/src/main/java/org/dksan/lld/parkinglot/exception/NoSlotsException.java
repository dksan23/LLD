package org.dksan.lld.parkinglot.exception;

public class NoSlotsException extends ParkingLotException{
    public NoSlotsException() {
    }

    public NoSlotsException(String message) {
        super(message);
    }
}
