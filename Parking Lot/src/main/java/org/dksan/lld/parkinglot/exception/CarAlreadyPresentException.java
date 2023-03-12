package org.dksan.lld.parkinglot.exception;

public class CarAlreadyPresentException extends ParkingLotException{
    public CarAlreadyPresentException() {
    }

    public CarAlreadyPresentException(String message) {
        super(message);
    }
}
