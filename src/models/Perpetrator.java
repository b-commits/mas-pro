package models;

import java.util.ArrayList;
import java.util.List;

public class Perpetrator {

    private String idNumber;
    private String alias;
    private int weight;
    private int height;
    private CriminalOrganization criminalOrganization;
    private List<String> offenses = new ArrayList<>();
    private List<Participation> participations = new ArrayList();

    public Perpetrator(String idNumber, String alias, int weight, int height, CriminalOrganization criminalOrganization) {
        this.idNumber = idNumber;
        this.alias = alias;
        this.weight = weight;
        this.height = height;
        criminalOrganization.addMember(this);
    }

    public void setCriminalOrganization(CriminalOrganization criminalOrganization) {
        if (this.criminalOrganization != null) {
            this.criminalOrganization.removeCriminalOrganization(this);
            this.criminalOrganization = null;
        }
        this.criminalOrganization = criminalOrganization;
        criminalOrganization.addMember(this);
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
        String orgName = this.criminalOrganization == null ? "Unaffiliated" : this.criminalOrganization.getName();
        return "Perpetrator{" +
                "idNumber='" + idNumber + '\'' +
                ", alias='" + alias + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", criminalOrganization=" + orgName +
                ", offenses=" + offenses +
                '}';
    }



}
