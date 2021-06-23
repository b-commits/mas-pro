package models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Response {

    private static final List<Response> responseExtent = new ArrayList<>();
    private final LocalTime timeReceived;
    private final LocalTime timeArrived;
    private final int numWitnessTestimony;
    private Event event;
    private OperationalGroup operationalGroup;

    public Response(LocalTime timeReceived, LocalTime timeArrived, int numWitnessTestimony, Event event, OperationalGroup operationalGroup) {
        this.timeReceived = timeReceived;
        this.timeArrived = timeArrived;
        this.numWitnessTestimony = numWitnessTestimony;
        event.addResponse(this);
        operationalGroup.addResponse(this);
        responseExtent.add(this);
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

    public long getResponseTime() {
        return MINUTES.between(timeArrived, timeReceived);
    }

}
