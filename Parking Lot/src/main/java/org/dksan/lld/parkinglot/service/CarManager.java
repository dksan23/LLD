package org.dksan.lld.parkinglot.service;

import org.dksan.lld.parkinglot.exception.CarAlreadyPresentException;
import org.dksan.lld.parkinglot.model.Car;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CarManager {

    HashSet<Car> cars;

    public CarManager() {
        cars = new HashSet<>();
    }

    public void addCar(Car car) throws CarAlreadyPresentException
    {
        if(cars.add(car) == false)
        {
            throw new CarAlreadyPresentException("Car Cant be added as it already present for REG NO:" + car.getRegNo());
        }
    }

    public List<String> getCarRegNosFromColor(String color)
    {
        List<String> result = new LinkedList<>();
        for(Car car : cars)
        {
            if(car.getColor() == color)
            {
                result.add(car.getRegNo());
            }
        }
        return result;
    }

    public void removeCar(Car car)
    {
        cars.remove(car);
    }
}
