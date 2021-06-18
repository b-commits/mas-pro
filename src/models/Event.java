package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private LocalDate date;
    private LocalTime time;
    private String location;
    private List<Participation> participations = new ArrayList();

    public Event(LocalDate date, LocalTime time, String location) {
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public void addParticipation(Participation participation) {
        if (!this.participations.contains(participation)) {
            this.participations.add(participation);
            participation.setEvent(this);
        }
    }

    public void removeParticipation(Participation participation) {
        participations.removeIf(participation1 -> participation1 == participation);
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", participationsSize=" + participations.size() +
                '}';
    }
}
