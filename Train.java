package com.epam.vehicle.model;


public class Train extends Vehicle {

    public Train(String make, String model, long speed) {
        super(make, model, speed);
    }

    @Override
    public long move(double duration) {
        // Train speeds up and slows down at half its speed for 0.2 hours
        double accelerationTime = 0.2;
        double accelerationDistance = getSpeed() / 2.0 * accelerationTime;
        double fullSpeedDistance = getSpeed() * (duration - accelerationTime);

        return Math.round(accelerationDistance + fullSpeedDistance);
    }

    @Override
    public String toString() {
        return "Train{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", speed=" + getSpeed() +
                '}';
    }
}
