import models.*;
import models.enums.OrganizationStatus;
import models.enums.InternationalStatus;
import models.exceptions.IdentikitDescriptionTooLongException;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Area area1 = new Area("Bemowo", "Niebezpieczna północna dzielnica", "3");
        CriminalOrganization org1 = new CriminalOrganization("Vendetta", "Drugs", OrganizationStatus.ACTIVE, InternationalStatus.WANTED);
        Perpetrator perp1 = new Perpetrator("123", "El Matador", 80, 153, org1);
        Event event1 = new Event(LocalDate.now(), LocalTime.now(), "Fuller & Franklin St.");

        try {
            Participation part1 = new Participation(LocalTime.now(), "Abba", perp1, event1);
            System.out.println(part1);
        } catch (IdentikitDescriptionTooLongException e) {
            e.printStackTrace();
        }
    }
}
