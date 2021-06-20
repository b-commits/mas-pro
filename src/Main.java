import models.*;

import java.util.ArrayList;

import static gui.resources.SampleData.generateOrganizations;
import static gui.resources.SampleData.generateOrganizationsarraylist;
import static helpers.ExtentIO.readExtent;
import static helpers.ExtentIO.writeExtent;

public class Main {
    public static void main(String[] args) {
//        writeExtent(generateOrganizationsarraylist());

        ArrayList<Object> deserialised = (ArrayList<Object>) readExtent();
        deserialised.forEach(System.out::println);
    }
}
