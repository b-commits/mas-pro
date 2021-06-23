package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static models.exceptions.ExceptionMessageProvider.REGISTRATION_ERROR_MESSAGE;

public class PoliceVehicle implements Serializable {

    private static final Map<String, PoliceVehicle> registrationNumbers = new HashMap<>();
    private final String brand;
    private final String model;
    private final LocalDate year;
    private final int mileage;
    private OperationalGroup operationalGroup;

    public PoliceVehicle(String brand, String model, LocalDate year, int mileage,
                         String registrationNumber, OperationalGroup group) throws Exception {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        setRegistrationNumber(registrationNumber);
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
