package com.epam.vehicle.logic;

import com.epam.vehicle.model.Car;
import com.epam.vehicle.model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class VehiclesCollection {
    private final List<Vehicle> vehicles;

    public VehiclesCollection() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicles.add(vehicle);
        }
    }


    public Vehicle getVehicle(String make, String model) {
        return vehicles.stream()
                .filter(v -> v.getMake().equals(make) && v.getModel().equals(model))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No vehicle found with make: " + make + " and model: " + model));
    }


    public List<Car> getCarsWhereModelYearIsBeforeSortedBySpeed(int modelYear) {
        return vehicles.stream()
                .filter(v -> v instanceof Car)
                .map(v -> (Car) v)
                .filter(car -> car.getModelYear() < modelYear)
                .sorted(Comparator.comparingLong(Vehicle::getSpeed))
                .collect(Collectors.toList());
    }


    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }
}
