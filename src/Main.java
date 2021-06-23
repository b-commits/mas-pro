import models.*;
import models.enums.InternationalStatus;
import models.enums.OrganizationStatus;
import models.enums.PerpetratorStatus;
import models.exceptions.DescriptionTooLongException;

import java.util.ArrayList;
import java.util.Objects;

import static gui.resources.SampleData.generateOrganizationsarraylist;
import static helpers.ExtentIO.readExtent;
import static helpers.ExtentIO.writeExtent;

public class Main {
    public static void main(String[] args) {

        try {
            Area area1 = new Area("Bemowo", "Dzielnica północna", "3");
            CriminalOrganization org1 = new CriminalOrganization("Niszczyciele Trybun", "Narkotyki", OrganizationStatus.ACTIVE, InternationalStatus.WANTED);
            Perpetrator perp1 = new Perpetrator("123", "John", 120, 198, PerpetratorStatus.KNOWN, org1);


            System.out.println(org1);
            System.out.println(perp1);
            System.out.println('\n');
            area1.addCriminalOrganization(org1);
            System.out.println(area1);
            System.out.println(org1);
            area1.removeCriminalOrganization(org1);
            System.out.println(area1);
            System.out.println(org1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         * Przykład użycia serializacji i deserializacji. Deserializowane są również obiekty
         * powiązane asocjacją.
         */
//        writeExtent(generateOrganizationsarraylist());
//
//        ArrayList<Object> deserialized = (ArrayList<Object>) readExtent();
//        Objects.requireNonNull(deserialized).forEach(item -> {
//            if (item instanceof CriminalOrganization) {
//                System.out.println(((CriminalOrganization) item).getMembers());
//            }
//        });
    }

}
