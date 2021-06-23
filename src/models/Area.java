package models;

import models.enums.AreaStatus;
import models.exceptions.DescriptionTooLongException;
import models.exceptions.InheritanceTypeException;

import java.util.ArrayList;
import java.util.List;

import static models.exceptions.ExceptionMessageProvider.DESCRIPTION_TOO_LONG_MESSAGE;

public class Area {

    private static List<Area> allAreas = new ArrayList<>();
    private final String name;
    private final List<CriminalOrganization> criminalOrganizations = new ArrayList<>();
    private String dangerLevel;
    private AreaStatus areaStatus;
    private String description;
    private Person monitoringOperator;

    public Area(String name, String description, String dangerLevel) throws DescriptionTooLongException {
        this.name = name;
        this.dangerLevel = dangerLevel;
        this.areaStatus = AreaStatus.OPEN;
        setDescription(description);
        allAreas.add(this);
    }

    public void addCriminalOrganization(CriminalOrganization criminalOrganization) {
        if (!criminalOrganizations.contains(criminalOrganization)) {
            criminalOrganizations.add(criminalOrganization);
            criminalOrganization.setArea(this);
        }
    }

    public List<CriminalOrganization> getCriminalOrganizations() {
        return criminalOrganizations;
    }

    public void setAreaStatus(AreaStatus areaStatus) {
        this.areaStatus = areaStatus;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public static void enforceTotalLockdown() {
        allAreas.forEach(area -> area.setAreaStatus(AreaStatus.LOCKDOWN));
    }

    public void removeCriminalOrganization(CriminalOrganization criminalOrganization) {
        criminalOrganizations.removeIf(criminalOrganization1 -> criminalOrganization1 == criminalOrganization);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dangerLevel='" + dangerLevel + '\'' +
                ", areaStatus=" + areaStatus +
                ", criminalOrganizationsSize=" + criminalOrganizations.size() +
                '}';
    }

    public void setOperator(Person operator) throws InheritanceTypeException {
        if (this.monitoringOperator != operator && this.monitoringOperator != null) {
            this.monitoringOperator.setArea(null);
            this.monitoringOperator = operator;
            monitoringOperator.setArea(this);
        }
        if (this.monitoringOperator == null) {
            this.monitoringOperator = operator;
            this.monitoringOperator.setArea(this);
        }
    }

    public void setDescription(String description) throws DescriptionTooLongException {
        if (description.length() > 500) throw new DescriptionTooLongException(DESCRIPTION_TOO_LONG_MESSAGE);
        else this.description = description;
    }

}
