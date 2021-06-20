package models;

import models.enums.AreaStatus;
import models.exceptions.InheritanceTypeException;

import java.util.ArrayList;
import java.util.List;

public class Area {

    private static final List<Area> areaExtent = new ArrayList<>();
    private final String name;
    private final String description;
    private final String dangerLevel;
    private final AreaStatus areaStatus;
    private final List<CriminalOrganization> criminalOrganizations = new ArrayList<>();
    private Person monitoringOperator;

    public Area(String name, String description, String dangerLevel) {
        this.name = name;
        this.description = description;
        this.dangerLevel = dangerLevel;
        this.areaStatus = AreaStatus.OPEN;
        areaExtent.add(this);
    }

    public void addCriminalOrganization(CriminalOrganization criminalOrganization) {
        if (!criminalOrganizations.contains(criminalOrganization)) {
            criminalOrganizations.add(criminalOrganization);
            criminalOrganization.setArea(this);
        }
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
}
