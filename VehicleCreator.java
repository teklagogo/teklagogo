package com.epam.vehicle.logic;

import com.epam.vehicle.model.Car;
import com.epam.vehicle.model.Train;
import com.epam.vehicle.model.Vehicle;


public class VehicleCreator {


    public Vehicle createVehicle(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        String[] parts = input.split(",");
        String type = parts[0].trim();

        switch (type) {
            case "Car":
                return createCar(parts);
            case "Train":
                return createTrain(parts);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    private Car createCar(String[] parts) {
        if (parts.length < 5) {
            throw new IllegalArgumentException("Not enough values for Car. Expected format: Car,make,model,speed,modelYear");
        }

        String make = parts[1].trim();
        String model = parts[2].trim();
        long speed;
        int modelYear;

        try {
            speed = Long.parseLong(parts[3].trim());
            modelYear = Integer.parseInt(parts[4].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + e.getMessage());
        }

        return new Car(make, model, speed, modelYear);
    }

    private Train createTrain(String[] parts) {
        if (parts.length < 4) {
            throw new IllegalArgumentException("Not enough values for Train. Expected format: Train,make,model,speed");
        }

        String make = parts[1].trim();
        String model = parts[2].trim();
        long speed;

        try {
            speed = Long.parseLong(parts[3].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + e.getMessage());
        }

        return new Train(make, model, speed);
    }
}
