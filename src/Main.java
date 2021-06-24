import models.Decoration;
import models.OperationalGroup;
import models.PoliceVehicle;

import java.time.LocalDate;

import static helpers.ExtentIO.writeAllExtents;
import static helpers.ExtentManager.showExtent;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * Przykład użycia serializacji i deserializacji. Deserializowane są również obiekty
         * powiązane asocjacją.
         */
        Decoration d1 = new Decoration("Medal of Honor", "as", LocalDate.now());
        OperationalGroup op1 = new OperationalGroup("123", "op-group-1");
        PoliceVehicle v1 = new PoliceVehicle("KIA", "X", LocalDate.now(), 1500, "123", op1);
        writeAllExtents();
        showExtent(Decoration.class);
        showExtent(OperationalGroup.class);
        showExtent(PoliceVehicle.class);
    }
}
