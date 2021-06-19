package models;

import models.enums.PersonType;
import models.enums.Ranks;
import models.exceptions.InheritanceTypeException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static models.exceptions.ExceptionMessageProvider.TYPE_ERROR_MESSAGE;

public class Person {
    private static final int MAX_BONUS = 1500;
    private static final int MAX_WEEKLY_HOURS = 18;
    private EnumSet<PersonType> personTypes = EnumSet.of(PersonType.DEFAULT_PERSON);

    // PersonType.DEFAULT_PERSON
    private String numPersonalIdentity;
    private String name;
    private String email;
    private String numPhone;

    // PersonType.POLICE_OFFICER
    private String numLicense;
    private LocalDate serviceStart;
    private Ranks rank;
    private int bonus;
    private int numCoursesCompleted;
    private List<Decoration> decorations = new ArrayList<>();
    private List<FirearmUse> firearmUses = new ArrayList<>();
    private List<String> awards = new ArrayList<>();
    private OperationalGroup operationalGroup;

    // PersonType.DISPATCHER
    private int numCallsReceived;
    private int avgCallTime;

    // PersonType.MONITORING_OPERATOR
    private int numDispatches;


    public void addDecoration(Decoration decoration) throws InheritanceTypeException {
        if (!personTypes.contains(PersonType.POLICE_OFFICER))
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        if (!decorations.contains(decoration)) {
            decorations.add(decoration);
            decoration.setReceiver(this);
        }
    }

    public void removeDecoration(Decoration decoration) throws InheritanceTypeException {
        if (!personTypes.contains(PersonType.POLICE_OFFICER))
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        decorations.removeIf(decoration1 -> decoration1 == decoration);
    }

    public void addFirearmUse(FirearmUse firearmUse) throws InheritanceTypeException {
        if (!personTypes.contains(PersonType.POLICE_OFFICER))
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        if (!firearmUses.contains(firearmUse)) {
            firearmUses.add(firearmUse);
            firearmUse.setShooter(this);
        }
    }

    public void removeFirearmUse(FirearmUse firearmUse) throws InheritanceTypeException {
        if (!personTypes.contains(PersonType.POLICE_OFFICER))
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        firearmUses.removeIf(firearmUse1 -> firearmUse1 == firearmUse);
    }

    public void setOperationalGroup(OperationalGroup operationalGroup) throws InheritanceTypeException {
        if (!personTypes.contains(PersonType.POLICE_OFFICER))
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        if (this.operationalGroup != null) {
            this.operationalGroup.removeOperationalGroup(this);
            this.operationalGroup = null;
        }
        this.operationalGroup = operationalGroup;
        operationalGroup.addMember(this);
    }
}
