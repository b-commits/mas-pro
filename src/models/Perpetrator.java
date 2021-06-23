package models;

import models.enums.PerpetratorStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Perpetrator implements Serializable {

    private final String idNumber;
    private final String alias;
    private final int weight;
    private final int height;
    private final PerpetratorStatus perpetratorStatus;
    private final List<CriminalOrganization> criminalOrganizations = new ArrayList<>();
    private final List<Participation> participations = new ArrayList<>();
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<String> offenses = new ArrayList<>();

    public Perpetrator(String idNumber, String alias, int weight, int height,
                       PerpetratorStatus perpetratorStatus, CriminalOrganization criminalOrganization) {
        this.idNumber = idNumber;
        this.alias = alias;
        this.weight = weight;
        this.height = height;
        this.perpetratorStatus = perpetratorStatus;
        criminalOrganization.addMember(this);
    }

    public void addCriminalOrganization(CriminalOrganization criminalOrganization) {
        if (!criminalOrganizations.contains(criminalOrganization)) {
            this.criminalOrganizations.add(criminalOrganization);
            criminalOrganization.addMember(this);
        }
    }

    public void addParticipation(Participation participation) {
        if (!this.participations.contains(participation)) {
            this.participations.add(participation);
            participation.setPerpetrator(this);
        }
    }

    public void removeParticipation(Participation participation) {
        participations.removeIf(participation1 -> participation1 == participation);
        participation.resetPerpetrator();
    }

    /**
     * The following methods are implicitly required by JavaFX even though they might not be used anywhere
     * else in the code. Deleting any of them will prevent GUI from populating appropriate tables.
     */

    @SuppressWarnings("unused")
    public String getIdNumber() {
        return idNumber;
    }

    @SuppressWarnings("unused")
    public String getAlias() {
        return alias;
    }

    @SuppressWarnings("unused")
    public int getWeight() {
        return weight;
    }

    @SuppressWarnings("unused")
    public int getHeight() {
        return height;
    }

    @SuppressWarnings("unused")
    public String getPerpetratorStatus() {
        return perpetratorStatus.name();
    }

    @SuppressWarnings("unused")
    public List<CriminalOrganization> getCriminalOrganizations() {
        return criminalOrganizations;
    }

    @Override
    public String toString() {
        String numOrg = this.criminalOrganizations.size() == 0 ? "Unaffiliated" : String.valueOf(criminalOrganizations.size());
        return "Perpetrator{" +
                "idNumber='" + idNumber + '\'' +
                ", alias='" + alias + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", criminalOrganizationsSize=" + numOrg +
                ", offenses=" + offenses +
                '}';
    }


    public void removeOrganization(CriminalOrganization criminalOrganization) {
        criminalOrganizations.remove(criminalOrganization);
        criminalOrganization.removeMember(this);
    }
}
