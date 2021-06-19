package models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static models.exceptions.ExceptionMessageProvider.REGISTRATION_ERROR_MESSAGE;

public class PoliceVehicle {
    private String brand;
    private String model;
    private LocalDate year;
    private int mileage;
    private OperationalGroup operationalGroup;
    private static Map<String, PoliceVehicle> registrationNumbers = new HashMap<>();

    public PoliceVehicle(String brand, String model, LocalDate year, int mileage, String registrationNumber) throws Exception {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;

        setRegistrationNumber(registrationNumber);
    }

    public PoliceVehicle(String brand, OperationalGroup group) {
        this.brand = brand;
        this.operationalGroup = null;
        group.setVehicle(this);
    }

    public void setRegistrationNumber(String registrationNumber) throws Exception {
        if (registrationNumbers.containsKey(registrationNumber)) {
            throw new Exception(REGISTRATION_ERROR_MESSAGE);
        } else registrationNumbers.put(registrationNumber, this);
    }

    public void setOperationalGroup(OperationalGroup operationalGroup) {
        if (this.operationalGroup != operationalGroup && this.operationalGroup != null) {
            this.operationalGroup.setVehicle(null);
            this.operationalGroup = operationalGroup;
            operationalGroup.setVehicle(this);
        }
        if (this.operationalGroup == null) {
            this.operationalGroup = operationalGroup;
            this.operationalGroup.setVehicle(this);
        }
    }

    @Override
    public String toString() {
        return "PoliceVehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage + '\'' +
                ", operationalGroup=" + operationalGroup.getName() +
                '}';
    }
}
