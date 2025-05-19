package com.epam.vehicle.model;


public class Car extends Vehicle {
    private int modelYear;

    public Car(String make, String model, long speed, int modelYear) {
        super(make, model, speed);
        this.modelYear = modelYear;
    }

    public int getModelYear() {
        return modelYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", speed=" + getSpeed() +
                ", modelYear=" + modelYear +
                '}';
    }
}
