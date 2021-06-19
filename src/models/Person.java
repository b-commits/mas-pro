package models;

import models.enums.PersonType;
import models.enums.Ranks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Person {
    private static final int MAX_BONUS = 1500;
    private static final int MAX_WEEKLY_HOURS = 18;
    private EnumSet<PersonType> personTypes = EnumSet.of(PersonType.DEFAULT_PERSON);

    private String numPersonalIdentity;
    private String name;
    private String email;
    private String numPhone;
    private List<Decoration> decorations = new ArrayList<>();
    private List<FirearmUse> firearmUses = new ArrayList<>();
    private List<String> awards = new ArrayList<>();
    private OperationalGroup operationalGroup;

    private String numLicense;
    private LocalDate serviceStart;
    private Ranks rank;
    private int bonus;
    private int numCoursesCompleted;

    private int numCallsReceived;
    private int avgCallTime;

    private int numDispatches;




    public void addDecoration(Decoration decoration) {
        if (!decorations.contains(decoration)) {
            decorations.add(decoration);
            decoration.setReceiver(this);
        }
    }

    public void removeDecoration(Decoration decoration) {
        decorations.removeIf(decoration1 -> decoration1 == decoration);
    }

    public void addFirearmUse(FirearmUse firearmUse) {
        if (!firearmUses.contains(firearmUse)) {
            firearmUses.add(firearmUse);
            firearmUse.setShooter(this);
        }
    }

    public void removeFirearmUse(FirearmUse firearmUse) {
        firearmUses.removeIf(firearmUse1 -> firearmUse1 == firearmUse);
    }

    public void setOperationalGroup(OperationalGroup operationalGroup) {
        // TODO: 19.06.2021
    }
}
