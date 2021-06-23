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
    private final EnumSet<PersonType> personTypes = EnumSet.of(PersonType.DEFAULT_PERSON);
    // PersonType.DEFAULT_PERSON
    private final String numPersonalIdentity;
    private final String name;
    private final String email;
    private final String numPhone;
    // PersonType.POLICE_OFFICER
    private String numLicense;
    private LocalDate serviceStart;
    private Ranks rank;
    private Integer bonus;
    private Integer numCoursesCompleted;
    private final List<Decoration> decorations = new ArrayList<>();
    private final List<FirearmUse> firearmUses = new ArrayList<>();
    private final List<String> awards = new ArrayList<>();
    private OperationalGroup operationalGroup;
    // PersonType.DISPATCHER
    private Integer numCallsReceived;
    private Integer avgCallTime;
    // PersonType.MONITORING_OPERATOR
    private Area area;
    private Integer numDispatches;

    public Person(String numPersonalIdentity, String name, String email, String numPhone) {
        this.numPersonalIdentity = numPersonalIdentity;
        this.name = name;
        this.email = email;
        this.numPhone = numPhone;
    }


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
            this.operationalGroup.removeMember(this);
            this.operationalGroup = null;
        }
        this.operationalGroup = operationalGroup;
        operationalGroup.addMember(this);
    }

    public void setArea(Area area) throws InheritanceTypeException {
        if (!personTypes.contains(PersonType.MONITORING_OPERATOR))
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.MONITORING_OPERATOR));
        if (this.area != area && this.area != null) {
            this.area.setOperator(null);
            this.area = area;
            area.setOperator(this);
        }
        if (this.area == null) {
            this.area = area;
            this.area.setOperator(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "numPersonalIdentity='" + numPersonalIdentity + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", numPhone='" + numPhone + '\'' +
                '}';
    }

    /**
     * The following getters are needed for demonstration purposes only.
     */

    @SuppressWarnings("unused")
    public String getNumPersonalIdentity() {
        return numPersonalIdentity;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
    public String getNumPhone() {
        return numPhone;
    }
}
