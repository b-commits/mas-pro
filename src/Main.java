import models.*;
import models.enums.OrganizationStatus;
import models.enums.InternationalStatus;

public class Main {
    public static void main(String[] args) {

        Area area1 = new Area("Bemowo", "Niebezpieczna północna dzielnica", "3");
        CriminalOrganization org1 = new CriminalOrganization("Vendetta", "Drugs", OrganizationStatus.ACTIVE, InternationalStatus.WANTED, 50);
        CriminalOrganization org2 = new CriminalOrganization("Bendetta", "Human trafficking", OrganizationStatus.ACTIVE, InternationalStatus.NOT_WANTED, 50);

        Perpetrator perp1 = new Perpetrator("123", "El Matador", 80, 153);
        org1.addMember(perp1);
        System.out.println(perp1);

        area1.addCriminalOrganization(org1);
        area1.addCriminalOrganization(org2);

        System.out.println(area1);
        System.out.println(org1);

    }
}
