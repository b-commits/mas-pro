package models;

import models.exceptions.InheritanceTypeException;

import java.time.LocalDate;
import java.time.LocalTime;

public class FirearmUse {

    private LocalDate date;
    private LocalTime time;
    private String typeRounds;
    private int numRounds;
    private Person shooter;
    private Firearm firearm;

    public FirearmUse(LocalDate date, LocalTime time, String typeRounds, int numRounds, Person shooter, Firearm firearm) throws InheritanceTypeException {
        this.date = date;
        this.time = time;
        this.typeRounds = typeRounds;
        this.numRounds = numRounds;
        shooter.addFirearmUse(this);
        firearm.addFirearmUse(this);
    }

    public void setFirearm(Firearm firearm) {
        if (this.firearm != null) {
            this.firearm.removeFirearmUse(this);
            this.firearm = null;
        }
        this.firearm = firearm;
        firearm.addFirearmUse(this);
    }

    public void setShooter(Person shooter) throws InheritanceTypeException {
        if (this.shooter != null) {
            this.shooter.removeFirearmUse(this);
            this.shooter = null;
        }
        this.shooter = shooter;
        shooter.addFirearmUse(this);
    }
}
