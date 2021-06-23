package models;

import models.enums.InternationalStatus;
import models.enums.OrganizationStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CriminalOrganization implements Serializable {

    private final List<Perpetrator> members = new ArrayList<>();
    private final String name;
    private final String business;
    private InternationalStatus internationalStatus;
    private OrganizationStatus organizationStatus;
    private Area area;

    public CriminalOrganization(String name, String business, OrganizationStatus organizationStatus,
                                InternationalStatus internationalStatus) {
        this.name = name;
        this.business = business;
        this.organizationStatus = organizationStatus;
        this.internationalStatus = internationalStatus;
    }

    public void addMember(Perpetrator member) {
        if (!members.contains(member)) {
            members.add(member);
            member.addCriminalOrganization(this);
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

    public List<Perpetrator> getMembers() {
        return members;
    }


    /**
     * The following methods are required by the project requirements, but I have not found any way
     * to use them any where in the code.
     */

    @SuppressWarnings("unused")
    public void updateStatus(OrganizationStatus organizationStatus) {
        this.organizationStatus = this.organizationStatus == OrganizationStatus.ACTIVE ?
                OrganizationStatus.DISBANDED : OrganizationStatus.ACTIVE;
    }

    @SuppressWarnings("unused")
    public void updateInternationalStatus(InternationalStatus internationalStatus) {
        this.internationalStatus = this.internationalStatus == InternationalStatus.WANTED ?
                InternationalStatus.NOT_WANTED : InternationalStatus.WANTED;
    }

    /**
     * The following methods are implicitly required by JavaFX even though they might not be used anywhere
     * else in the code. Deleting any of them will prevent GUI from populating appropriate tables.
     */

    @SuppressWarnings("unused")
    public Area getArea() {
        return area;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getBusiness() { return business; }

    @SuppressWarnings("unused")
    public String getInternationalStatus() { return internationalStatus.name(); }

    @SuppressWarnings("unused")
    public String getOrganizationStatus() { return organizationStatus.name(); }

    @SuppressWarnings("unused")
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
}