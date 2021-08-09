package helpers;

import models.exceptions.ExtentDoesNotExist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static models.exceptions.ExceptionMessageProvider.STORED_EXTENT_MESSAGE;

/**
 * All business classes should extend this class in order to be serialised.
 * ExtentIO classes has all the methods needed to output serialised .ser files
 * for either a single extent of a given class or a top-level extent of all business classes.
 */
public abstract class ExtentManager implements Serializable {

    public static final Map<Class, List<ExtentManager>> allExtents = new Hashtable<>();

    public ExtentManager() {
        List extent = null;
        Class theClass = this.getClass();

        if (allExtents.containsKey(theClass)) extent = allExtents.get(theClass);
        else {
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException {
        if(allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }

        throw new ClassNotFoundException(String.format(STORED_EXTENT_MESSAGE, type.toString(), allExtents.keySet()));
    }

    public static void showExtent(Class theClass) throws ExtentDoesNotExist {
        List extent = null;
        if (allExtents.containsKey(theClass)) extent = allExtents.get(theClass);
        else throw new ExtentDoesNotExist("Unknown class: " + theClass);
        extent.forEach(System.out::println);
    }

}
