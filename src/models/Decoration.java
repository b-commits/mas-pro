package models;

import helpers.ExtentManager;
import models.exceptions.InheritanceTypeException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static models.exceptions.ExceptionMessageProvider.OVER_LIMIT_ERROR_MESSAGE;

public class Decoration extends ExtentManager implements Serializable {

    private static final int MAX_DESCRIPTION_LENGTH = 500;
    private final List<Person> receivers = new ArrayList<>();
    private final String name;
    private final LocalDate dateReceived;
    private String description;


    public Decoration(String name, String description, LocalDate dateReceived) throws Exception {
        this.name = name;
        this.dateReceived = dateReceived;
        this.setDescription(description);
    }

    private void setDescription(String description) throws Exception {
        if (description.length() < MAX_DESCRIPTION_LENGTH) this.description = description;
        else throw new Exception(OVER_LIMIT_ERROR_MESSAGE);
    }

    public void addReceiver(Person receiver) throws InheritanceTypeException {
        if (!receivers.contains(receiver)) {
            receivers.add(receiver);
            receiver.addDecoration(this);
        }
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "name='" + name + '\'' +
                ", dateReceived=" + dateReceived +
                ", description='" + description + '\'' +
                ", receivers=" + receivers +
                '}';
    }

    /**
     * These methods can potentially be implicitly required by JavaFX GUI.
     * Deleting them may break GUI tables.
     */

    @SuppressWarnings("unused")
    public String getDescription() {
        return description;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public LocalDate getDateReceived() {
        return dateReceived;
    }
}
