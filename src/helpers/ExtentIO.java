package helpers;

import java.io.*;
import java.util.ArrayList;

public class ExtentIO {

    public static final String POLICE_EXTENT_DIR = "data.ser";
    public static final String TEST_POLICE_EXTENT_DIR =  "app-data.ser";

    public static void writeExtent(ArrayList<?> extent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(POLICE_EXTENT_DIR))) {
            out.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllExtents() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(POLICE_EXTENT_DIR))) {
            out.writeObject(ExtentManager.allExtents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readExtent() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(POLICE_EXTENT_DIR))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Deprecated()
    public static Object oldReadExtent() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(TEST_POLICE_EXTENT_DIR))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
