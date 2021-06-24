package models;

import helpers.ExtentManager;
import models.exceptions.IllegalRegistrationNumberException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static models.exceptions.ExceptionMessageProvider.FIREARM_NUM_REGISTRATION_ERROR_MESSAGE;
import static models.providers.RegexPatternProvider.NUM_REGISTRATION_PATTERN;

public class Firearm extends ExtentManager implements Serializable {

    private String numRegistration;
    private final String model;
    private final String type;
    private final String caliber;
    private final String magSize;
    private final List<FirearmUse> firearmUses = new ArrayList<>();

    public Firearm(String model, String numRegistration, String type, String caliber, String magSize)
            throws IllegalRegistrationNumberException {
        super();
        this.setNumRegistration(numRegistration);
        this.model = model;
        this.type = type;
        this.caliber = caliber;
        this.magSize = magSize;
    }

    private void setNumRegistration(String numRegistration) throws IllegalRegistrationNumberException {
        Matcher matcher = NUM_REGISTRATION_PATTERN.matcher(numRegistration);
        if (matcher.matches()) this.numRegistration = numRegistration;
        else throw new IllegalRegistrationNumberException(FIREARM_NUM_REGISTRATION_ERROR_MESSAGE);
    }

    public void addFirearmUse(FirearmUse firearmUse) {
        if (!firearmUses.contains(firearmUse)) {
            firearmUses.add(firearmUse);
            firearmUse.setFirearm(this);
        }
    }

    public void removeFirearmUse(FirearmUse firearmUse) {
        firearmUses.removeIf(firearmUse1 -> firearmUse1 == firearmUse);
    }

    @Override
    public String toString() {
        return "Firearm{" +
                "model='" + model + '\'' +
                ", numRegistration='" + numRegistration + '\'' +
                ", type='" + type + '\'' +
                ", caliber='" + caliber + '\'' +
                ", magSize='" + magSize + '\'' +
                ", firearmUsesSize=" + firearmUses.size() +
                '}';
    }

    /**
     * These methods can potentially be implicitly required by JavaFX GUI.
     * Deleting them may break GUI tables.
     */

    @SuppressWarnings("unused")
    public String getModel() {
        return model;
    }

    @SuppressWarnings("unused")
    public String getNumRegistration() {
        return numRegistration;
    }

    @SuppressWarnings("unused")
    public String getType() {
        return type;
    }

    @SuppressWarnings("unused")
    public String getCaliber() {
        return caliber;
    }

    @SuppressWarnings("unused")
    public String getMagSize() {
        return magSize;
    }
}
