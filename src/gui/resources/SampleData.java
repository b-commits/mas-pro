package gui.resources;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.CriminalOrganization;
import models.Perpetrator;
import models.enums.InternationalStatus;
import models.enums.OrganizationStatus;
import models.enums.PerpetratorStatus;

public class SampleData {

    private static final ObservableList<CriminalOrganization> organizations = FXCollections.observableArrayList();

    public static ObservableList<CriminalOrganization> generateOrganizations() {
        CriminalOrganization organization1 = new CriminalOrganization("Los matadores", "Dystrybucja narkotyków", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization2 = new CriminalOrganization("La Ropa Vieja", "Kradzieże", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization3 = new CriminalOrganization("Niszczyciele Trybun", "Rozboje", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization4 = new CriminalOrganization("KPPS", "Przemyt", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization5 = new CriminalOrganization("Dobre chłopaki", "Rozboje", OrganizationStatus.ACTIVE, InternationalStatus.WANTED);
        CriminalOrganization organization6 = new CriminalOrganization("No name", "Rozboje", OrganizationStatus.DISBANDED, InternationalStatus.NOT_WANTED);
        CriminalOrganization organization7 = new CriminalOrganization("Złodziejaszki", "Kradzieże", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization8 = new CriminalOrganization("Peaky Blinders", "Rozboje", OrganizationStatus.ACTIVE, InternationalStatus.WANTED);
        CriminalOrganization organization9 = new CriminalOrganization("Beaky Plinders", "Przemyt kotków", OrganizationStatus.DISBANDED, InternationalStatus.NOT_WANTED);
        CriminalOrganization organization10 = new CriminalOrganization("Kurde Nie Wiem Już", "Nieznana", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization11 = new CriminalOrganization("Tokyo Mafia", "Kradzieże", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization12 = new CriminalOrganization("Poznań Ekipa", "Stręczycielstwo", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization13 = new CriminalOrganization("Grupa Dwojga", "Wymuszenia", OrganizationStatus.DISBANDED, InternationalStatus.NOT_WANTED);
        CriminalOrganization organization14 = new CriminalOrganization("Cosa Nostra", "Wszystko możliwe", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization15 = new CriminalOrganization("Mocni 2001", "Rozboje", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization16 = new CriminalOrganization("Grupa Słabych Złodziei", "Złodziejstwo", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization17 = new CriminalOrganization("La viglia del aguila", "Wszystko możliwe", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        CriminalOrganization organization18 = new CriminalOrganization("Titanic", "Stręczycielstwo", OrganizationStatus.DISBANDED, InternationalStatus.WANTED);
        Perpetrator perp1 = new Perpetrator("1", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp2 = new Perpetrator("2", "Ucho", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp3 = new Perpetrator("3", "Joe Mohammadi", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp4 = new Perpetrator("4", "Michael Scott", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp5 = new Perpetrator("5", "Mike", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp6 = new Perpetrator("6", "I dunno", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp7 = new Perpetrator("7", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp8 = new Perpetrator("8", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp9 = new Perpetrator("9", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp10 = new Perpetrator("10", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp11 = new Perpetrator("11", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp12 = new Perpetrator("12", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp13 = new Perpetrator("13", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp14 = new Perpetrator("14", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp15 = new Perpetrator("15", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);
        Perpetrator perp16 = new Perpetrator("16", "El jefe", 195, 58, PerpetratorStatus.WANTED, organization1);



        organizations.add(organization1);
        organizations.add(organization2);
        organizations.add(organization3);
        organizations.add(organization4);
        organizations.add(organization5);
        organizations.add(organization6);
        organizations.add(organization7);
        organizations.add(organization8);
        organizations.add(organization9);
        organizations.add(organization10);
        organizations.add(organization11);
        organizations.add(organization12);
        organizations.add(organization13);
        organizations.add(organization14);
        organizations.add(organization15);
        organizations.add(organization16);
        organizations.add(organization17);
        organizations.add(organization18);
        return organizations;
    }


}
