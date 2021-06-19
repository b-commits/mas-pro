package models;

import models.exceptions.IllegalRegistrationNumber;

import java.util.regex.Matcher;

import static models.exceptions.ExceptionMessageProvider.FIREARM_NUM_REGISTRATION_ERROR_MESSAGE;
import static models.providers.RegexPatternProvider.NUM_REGISTRATION_PATTERN;

public class Firearm {
    private String model;
    private String numRegistration;
    private String type;
    private String caliber;
    private String magSize;

    public Firearm(String model, String numRegistration, String type, String caliber, String magSize) throws IllegalRegistrationNumber {
        this.setNumRegistration(numRegistration);
        this.model = model;
        this.type = type;
        this.caliber = caliber;
        this.magSize = magSize;
    }

    private void setNumRegistration(String numRegistration) throws IllegalRegistrationNumber {
        Matcher matcher = NUM_REGISTRATION_PATTERN.matcher(numRegistration);
        if (matcher.matches()) this.numRegistration = numRegistration;
        else throw new IllegalRegistrationNumber(FIREARM_NUM_REGISTRATION_ERROR_MESSAGE);
    }

}
