package models;

import models.enums.PerpetratorStatus;

import java.util.ArrayList;
import java.util.List;

public class Perpetrator {

    private String idNumber;
    private String alias;
    private int weight;
    private int height;
    private PerpetratorStatus perpetratorStatus;
    private List<CriminalOrganization> criminalOrganizations = new ArrayList<>();
    private List<String> offenses = new ArrayList<>();
    private List<Participation> participations = new ArrayList();

    public Perpetrator(String idNumber, String alias, int weight, int height, PerpetratorStatus perpetratorStatus, CriminalOrganization criminalOrganization) {
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



}
