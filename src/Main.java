import models.Decoration;

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
        writeAllExtents();
        showExtent(Decoration.class);
    }
}
