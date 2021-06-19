package models;

import models.exceptions.IdentikitDescriptionTooLongException;

import java.time.LocalTime;

import static models.exceptions.ExceptionMessageProvider.IDENTIKIT_OVER_LIMIT_ERROR;

public class Participation {

    private static final int IDENTIKIT_DESC_MAX_LENGTH = 500;
    private LocalTime timeSpotted;
    private String identikitDescription;
    private Perpetrator perpetrator;
    private Event event;

    public Participation(LocalTime timeSpotted, String identikitDescription, Perpetrator perpetrator, Event event) throws IdentikitDescriptionTooLongException {
        this.timeSpotted = timeSpotted;
        setIdentikitDescription(identikitDescription);
        perpetrator.addParticipation(this);
        event.addParticipation(this);
    }

    public void setIdentikitDescription(String identikitDescription) throws IdentikitDescriptionTooLongException {
        if (identikitDescription.length() < IDENTIKIT_DESC_MAX_LENGTH) this.identikitDescription = identikitDescription;
        else throw new IdentikitDescriptionTooLongException(String.format(IDENTIKIT_OVER_LIMIT_ERROR, IDENTIKIT_DESC_MAX_LENGTH));
    }

    public void setPerpetrator(Perpetrator perpetrator) {
        if (this.perpetrator != null) {
            this.perpetrator.removeParticipation(this);
            this.perpetrator = null;
        }
        this.perpetrator = perpetrator;
        perpetrator.addParticipation(this);
    }

    public void setEvent(Event event) {
        if (this.event != null) {
            this.event.removeParticipation(this);
            this.event = null;
        }
        this.event = event;
        event.addParticipation(this);
    }

    @Override
    public String toString() {
        return "Participation{" +
                "timeSpotted=" + timeSpotted +
                ", identikitDescription='" + identikitDescription + '\'' +
                ", perpetrator=" + perpetrator +
                ", event=" + event +
                '}';
    }
}
