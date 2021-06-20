package models;

import models.exceptions.IllegalRegistrationNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static models.exceptions.ExceptionMessageProvider.FIREARM_NUM_REGISTRATION_ERROR_MESSAGE;
import static models.providers.RegexPatternProvider.NUM_REGISTRATION_PATTERN;

public class Firearm {

    private static List<Firearm> firearmExtent = new ArrayList<>();
    private String model;
    private String numRegistration;
    private String type;
    private String caliber;
    private String magSize;
    private List<FirearmUse> firearmUses = new ArrayList<>();

    public Firearm(String model, String numRegistration, String type, String caliber, String magSize) throws IllegalRegistrationNumberException {
        this.setNumRegistration(numRegistration);
        this.model = model;
        this.type = type;
        this.caliber = caliber;
        this.magSize = magSize;
        firearmExtent.add(this);
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
}
