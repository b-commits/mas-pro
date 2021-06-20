package models;

import models.enums.InternationalStatus;
import models.enums.OrganizationStatus;

import java.util.ArrayList;
import java.util.List;

public class CriminalOrganization {

    private static List<CriminalOrganization> criminalOrganizationExtent = new ArrayList<>();
    private String name;
    private String business;
    private OrganizationStatus organizationStatus;
    private InternationalStatus internationalStatus;
    private Area area;
    private List<Perpetrator> members = new ArrayList<>();

    public CriminalOrganization(String name, String business,
                                OrganizationStatus organizationStatus,
                                InternationalStatus internationalStatus) {
        this.name = name;
        this.business = business;
        this.organizationStatus = organizationStatus;
        this.internationalStatus = internationalStatus;
        criminalOrganizationExtent.add(this);
    }

    @Deprecated
    public CriminalOrganization(String name, String business) {
        this.name = name;
        this.business = business;
    }

    public void addMember(Perpetrator member) {
        if (!members.contains(member)) {
            members.add(member);
            member.addCriminalOrganization(this);
        }
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        if (this.area != null) {
            this.area.removeCriminalOrganization(this);
            this.area = null;
        }
        this.area = area;
        area.addCriminalOrganization(this);
    }

    public String getName() {
        return name;
    }

    public String getBusiness() { return business; }

    public String getInternationalStatus() { return internationalStatus.name(); }

    public String getOrganizationStatus() { return organizationStatus.name(); }

    public void removeCriminalOrganization(Perpetrator member) {
        members.removeIf(member1 -> member1 == member);
    }

    @Override
    public String toString() {
        String areaInfo = area == null ? "No area" : area.getName();
        return "CriminalOrganization{" +
                "name='" + name + '\'' +
                ", business='" + business + '\'' +
                ", organizationStatus=" + organizationStatus +
                ", area=" + areaInfo +
                ", internationalStatus=" + internationalStatus +
                ", numberOfMembers=" + members.size() +
                '}';
    }

    public List<Perpetrator> getMembers() {
        return members;
    }
}