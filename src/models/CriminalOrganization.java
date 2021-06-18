package models;

import models.enums.InternationalStatus;
import models.enums.OrganizationStatus;

import java.util.ArrayList;
import java.util.List;

public class CriminalOrganization {
    private String name;
    private String business;
    private OrganizationStatus organizationStatus;
    private InternationalStatus internationalStatus;
    private Area area;
    private List<Perpetrator> members = new ArrayList<>();
    private int numberOfMembers;

    public CriminalOrganization(String name, String business,
                                OrganizationStatus organizationStatus,
                                InternationalStatus internationalStatus,
                                int numberOfMembers) {
        this.name = name;
        this.business = business;
        this.organizationStatus = organizationStatus;
        this.internationalStatus = internationalStatus;
        this.numberOfMembers = numberOfMembers;
    }

    public void addMember(Perpetrator member) {
        if (!members.contains(member)) {
            members.add(member);
            member.setCriminalOrganization(this);
        }
    }

    public void setArea(Area area) {
        if (this.area != null) {
            this.area.removeCriminalOrganization(this);
            this.area = null;
        }
        this.area = area;
        area.addCriminalOrganization(this);
    }

    public Area getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public void removeCriminalOrganization(Perpetrator member) {
        members.removeIf(member1 -> member1 == member);
    }

    @Override
    public String toString() {
        return "CriminalOrganization{" +
                "name='" + name + '\'' +
                ", business='" + business + '\'' +
                ", organizationStatus=" + organizationStatus +
                ", area=" + area.getName() +
                ", internationalStatus=" + internationalStatus +
                ", numberOfMembers=" + members.size() +
                '}';
    }
}