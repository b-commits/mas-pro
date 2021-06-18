import models.*;

public class Main {
    public static void main(String[] args) {
        try {
            OperationalGroup group1 = new OperationalGroup("123");
            PoliceVehicle vehicle1 = new PoliceVehicle("KIA");
            group1.setVehicle(vehicle1);
            System.out.println(vehicle1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
