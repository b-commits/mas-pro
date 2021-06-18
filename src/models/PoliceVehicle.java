package models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PoliceVehicle {
    private String brand;
    private String model;
    private LocalDate year;
    private int mileage;
    private static Map<String, PoliceVehicle> registrationNumbers = new HashMap<>();

    public PoliceVehicle(String brand, String model, LocalDate year, int mileage, String registrationNumber) throws Exception {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        setRegistrationNumber(registrationNumber);
    }

    public void setRegistrationNumber(String registrationNumber) throws Exception {
        if (registrationNumbers.containsKey(registrationNumber)) {
            throw new Exception("Registration number has already been used.");
        } else registrationNumbers.put(registrationNumber, this);
    }

    @Override
    public String toString() {
        return "PoliceVehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }
}
