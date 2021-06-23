package models;

import models.exceptions.InheritanceTypeException;

import java.time.LocalDate;

import static models.exceptions.ExceptionMessageProvider.OVER_LIMIT_ERROR_MESSAGE;

public class Decoration {

    private final String name;
    private String description;
    private final LocalDate dateReceived;
    private Person receiver;

    public Decoration(String name, String description, LocalDate dateReceived) throws Exception {
        this.name = name;
        this.dateReceived = dateReceived;
        this.setDescription(description);
    }

    private void setDescription(String description) throws Exception {
        if (description.length() < 500) this.description = description;
        else throw new Exception(OVER_LIMIT_ERROR_MESSAGE);
    }

    public void setReceiver(Person receiver) throws InheritanceTypeException {
        if (this.receiver != null) {
            this.receiver.removeDecoration(this);
            this.receiver = null;
        }
        this.receiver = receiver;
        receiver.addDecoration(this);
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
