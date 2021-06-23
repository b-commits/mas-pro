import models.*;

import java.util.ArrayList;
import java.util.Objects;

import static gui.resources.SampleData.generateOrganizationsarraylist;
import static helpers.ExtentIO.readExtent;
import static helpers.ExtentIO.writeExtent;

public class Main {
    public static void main(String[] args) {






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
