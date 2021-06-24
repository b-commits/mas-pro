package models;

import helpers.ExtentManager;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Response extends ExtentManager implements Serializable {

    private final LocalTime timeReceived;
    private final LocalTime timeArrived;
    private final List<String> witnessTestimonies = new ArrayList<>();
    private Event event;
    private OperationalGroup operationalGroup;

    public Response(LocalTime timeReceived, LocalTime timeArrived, Event event, OperationalGroup operationalGroup) {
        super();
        this.timeReceived = timeReceived;
        this.timeArrived = timeArrived;
        event.addResponse(this);
        operationalGroup.addResponse(this);
    }

    // Demonstration purposes only.
    @SuppressWarnings("unused")
    public void addWitnessTestimony(String testimony) {
        witnessTestimonies.add(testimony);
    }

    // Demonstration purposes only.
    @SuppressWarnings("unused")
    public void getWitnessTestimonies() {
        witnessTestimonies.forEach(System.out::println);
    }

    public void setOperationalGroup(OperationalGroup operationalGroup) {
        if (this.operationalGroup != null) {
            this.operationalGroup.removeResponse(this);
            this.operationalGroup = null;
        }
        this.operationalGroup = operationalGroup;
        operationalGroup.addResponse(this);
    }

    public void setEvent(Event event) {
        if (this.event != null) {
            this.event.removeResponse(this);
            this.event = null;
        }
        this.event = event;
        event.addResponse(this);
    }

    /**
     * The following methods are needed for demonstration purposes only.
     */

    @SuppressWarnings("unused")
    public long getResponseTime() {
        return MINUTES.between(timeArrived, timeReceived);
    }

    public void resetOperationalGroup() {
        this.operationalGroup = null;
    }
}
