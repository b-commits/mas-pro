package models;

import helpers.ExtentManager;
import models.enums.PersonType;
import models.enums.Ranks;
import models.exceptions.InheritanceTypeException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static models.exceptions.ExceptionMessageProvider.*;

public class Person extends ExtentManager implements Serializable {

    private static final List<Person> allPeople = new ArrayList<>();
    private static final int MIN_LICENSE_LENGTH = 7;
    private static final int MAX_BONUS = 1500;
    @SuppressWarnings("unused") private static final int DISPATCHER_MAX_WEEKLY_HOURS = 18;
    private final EnumSet<PersonType> personTypes = EnumSet.of(PersonType.DEFAULT_PERSON);

    private final String numPersonalIdentity;
    private final String name;
    private final String email;
    private final String numPhone;

    private final List<String> licenses = new ArrayList<>();
    private String numLicense;
    private LocalDate serviceStart;
    private Ranks rank;
    private Integer bonus;
    private Integer numCoursesCompleted;
    private final List<Decoration> decorations = new ArrayList<>();
    private final List<FirearmUse> firearmUses = new ArrayList<>();
    private final List<String> awards = new ArrayList<>();
    private OperationalGroup operationalGroup;

    private Integer numCallsReceived;
    private Integer avgCallTime;

    private Area area;
    private Integer numDispatches;

    public Person(String numPersonalIdentity, String name, String email, String numPhone) {
        super();
        this.numPersonalIdentity = numPersonalIdentity;
        this.name = name;
        this.email = email;
        this.numPhone = numPhone;
    }

    @SuppressWarnings("unused")
    public void setNumLicense(String numLicense) throws Exception {
        if (licenses.contains(numLicense)) throw new Exception(LICENSE_IN_USE_MESSAGE);
        if (numLicense.length() < MIN_LICENSE_LENGTH) throw new Exception(LICENSE_TOO_SHORT_MESSAGE);
        if (this.isPoliceOfficer()) {
            licenses.add(numLicense);
            this.numLicense = numLicense;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
    }

    @SuppressWarnings("unused")
    public String getNumLicense() {
        return numLicense;
    }

    @SuppressWarnings("unused")
    public void setServiceStart(LocalDate serviceStart) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        this.serviceStart = serviceStart;
    }

    @SuppressWarnings("unused")
    public LocalDate getServiceStart() {
        return serviceStart;
    }

    @SuppressWarnings("unused")
    public void setRank(Ranks rank) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        this.rank = rank;
    }

    @SuppressWarnings("unused")
    public void setBonus(Integer bonus) throws Exception {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        if (bonus < MAX_BONUS) this.bonus = bonus;
        else throw new Exception(OVER_LIMIT_ERROR_MESSAGE);
    }

    @SuppressWarnings("unused")
    public void setNumCoursesCompleted(Integer numCoursesCompleted) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        this.numCoursesCompleted = numCoursesCompleted;
    }

    @SuppressWarnings("unused")
    public void addAward(String award) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        this.awards.add(award);
    }

    @SuppressWarnings("unused")
    public void setNumCallsReceived(Integer numCallsReceived) throws InheritanceTypeException {
        if (!this.isDispatcher())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.DISPATCHER));
        this.numCallsReceived = numCallsReceived;
    }

    @SuppressWarnings("unused")
    public void setAvgCallTime(Integer avgCallTime) throws InheritanceTypeException {
        if (!this.isDispatcher())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.DISPATCHER));
        this.avgCallTime = avgCallTime;
    }

    @SuppressWarnings("unused")
    public void setNumDispatches(Integer numDispatches) throws InheritanceTypeException {
        if (!this.isMonitoringOperator())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.MONITORING_OPERATOR));
        this.numDispatches = numDispatches;
    }


    public void addDecoration(Decoration decoration) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        if (!decorations.contains(decoration)) {
            decorations.add(decoration);
            decoration.addReceiver(this);
        }
    }

    public void addFirearmUse(FirearmUse firearmUse) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        if (!firearmUses.contains(firearmUse)) {
            firearmUses.add(firearmUse);
            firearmUse.setShooter(this);
        }
    }

    public void removeFirearmUse(FirearmUse firearmUse) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        firearmUses.removeIf(firearmUse1 -> firearmUse1 == firearmUse);
    }

    public void setOperationalGroup(OperationalGroup operationalGroup) throws InheritanceTypeException {
        if (!this.isPoliceOfficer())
            throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, PersonType.POLICE_OFFICER));
        if (this.operationalGroup != null) {
            this.operationalGroup.removeMember(this);
            this.operationalGroup = null;
        }
        this.operationalGroup = operationalGroup;
        operationalGroup.addMember(this);
    }

    /**
     * The following "become" methods dictate inherited subtypes and allow for the realization of overlapped
     * inheritance. Demonstration purposes only.
     */
    @SuppressWarnings("unused")
    public void becomePoliceOfficer(int numCoursesCompleted) {
        if (!this.isDispatcher()) {
            this.personTypes.remove(PersonType.MONITORING_OPERATOR);
        }
        this.personTypes.add(PersonType.POLICE_OFFICER);
        this.numCoursesCompleted = numCoursesCompleted;
    }

    @SuppressWarnings("unused")
    public void becomeDispatcher() {
        if (!this.isPoliceOfficer()) {
            this.personTypes.remove(PersonType.MONITORING_OPERATOR);
        }
        this.personTypes.add(PersonType.DISPATCHER);
    }

    @SuppressWarnings("unused")
    public void becomeMonitoringOperator() {
        this.personTypes.remove(PersonType.POLICE_OFFICER);
        this.personTypes.remove(PersonType.DISPATCHER);
        this.personTypes.add(PersonType.MONITORING_OPERATOR);
    }


    public void setArea(Area area) throws InheritanceTypeException {
        if (!this.isMonitoringOperator())
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

    @SuppressWarnings("unused")
    public static void getAllInfo() {
        allPeople.forEach(System.out::println);
    }

    @SuppressWarnings("unused")
    public static void getAllOfficerInfo() {
        allPeople.forEach(person -> {
            if (person.isPoliceOfficer()) System.out.println(person);
        });
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

    public boolean isDispatcher() {
        return personTypes.contains(PersonType.DISPATCHER);
    }

    public boolean isPoliceOfficer() {
        return personTypes.contains(PersonType.POLICE_OFFICER);
    }

    public boolean isMonitoringOperator() {
        return personTypes.contains(PersonType.MONITORING_OPERATOR);
    }

    @SuppressWarnings("unused")
    public Integer getNumCallsReceived() {
        return numCallsReceived;
    }

    @SuppressWarnings("unused")
    public Ranks getRank() {
        return rank;
    }

    @SuppressWarnings("unused")
    public Integer getBonus() {
        return bonus;
    }

    @SuppressWarnings("unused")
    public Integer getNumCoursesCompleted() {
        return numCoursesCompleted;
    }

    @SuppressWarnings("unused")
    public Integer getNumDispatches() {
        return numDispatches;
    }

    @SuppressWarnings("unused")
    public Integer getAvgCallTime() {
        return avgCallTime;
    }

    @SuppressWarnings("unused")
    public void getAwards() {
        awards.forEach(System.out::println);
    }
}
