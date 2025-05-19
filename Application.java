package com.epam.vehicle;

import com.epam.vehicle.logic.VehicleCreator;
import com.epam.vehicle.logic.VehiclesCollection;
import com.epam.vehicle.model.Car;
import com.epam.vehicle.model.Vehicle;

import java.util.List;
import java.util.NoSuchElementException;


public class Application {

    public static void main(String[] args) {
        // Demonstrate VehicleCreator
        System.out.println("Creating vehicles from text input:");
        VehicleCreator creator = new VehicleCreator();

        try {
            // Create a car
            Vehicle car = creator.createVehicle("Car,Toyota,Corolla,140,1966");
            System.out.println("Created car: " + car);

            // Create a train
            Vehicle train = creator.createVehicle("Train,Siemens,ICE 4,300");
            System.out.println("Created train: " + train);

            // Demonstrate move() method
            System.out.println("\nTesting vehicle movement:");
            double duration = 1.5;
            System.out.println("Car moving for " + duration + " hours covers " + car.move(duration) + " km");
            System.out.println("Train moving for " + duration + " hours covers " + train.move(duration) + " km");

            // Demonstrate VehiclesCollection
            System.out.println("\nTesting vehicle collection:");
            VehiclesCollection collection = new VehiclesCollection();

            // Add vehicles to collection
            collection.addVehicle(car);
            collection.addVehicle(train);
            collection.addVehicle(creator.createVehicle("Car,Honda,Civic,130,2010"));
            collection.addVehicle(creator.createVehicle("Car,Ford,Mustang,180,1969"));
            collection.addVehicle(creator.createVehicle("Car,Tesla,Model S,220,2020"));

            // Test getVehicle
            try {
                Vehicle foundVehicle = collection.getVehicle("Toyota", "Corolla");
                System.out.println("Found vehicle: " + foundVehicle);
            } catch (NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Test searching for older cars sorted by speed
            System.out.println("\nCars made before 2000, sorted by speed:");
            List<Car> oldCars = collection.getCarsWhereModelYearIsBeforeSortedBySpeed(2000);
            oldCars.forEach(System.out::println);

            // Test error handling
            System.out.println("\nTesting error handling:");
            try {
                creator.createVehicle("Boat,Yamaha,Marine,60");
                System.out.println("This should not be printed!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error caught: " + e.getMessage());
            }

            try {
                creator.createVehicle("Car,Toyota,Corolla,140");
                System.out.println("This should not be printed!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error caught: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
