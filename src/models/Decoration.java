package models;

import models.exceptions.InheritanceTypeException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static models.exceptions.ExceptionMessageProvider.OVER_LIMIT_ERROR_MESSAGE;

public class Decoration {

    private static List<Decoration> decorationExtent = new ArrayList<>();
    private String name;
    private String description;
    private LocalDate dateReceived;
    private Person receiver;

    public Decoration(String name, String description, LocalDate dateReceived) throws Exception {
        this.name = name;
        this.dateReceived = dateReceived;
        this.setDescription(description);
        decorationExtent.add(this);
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
}
