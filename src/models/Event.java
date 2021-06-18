package models;

import models.enums.EventType;
import models.exceptions.InheritanceTypeException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static models.exceptions.ExceptionMessageProvider.TYPE_ERROR_MESSAGE;

public class Event {

    private LocalDate date;
    private LocalTime time;
    private String location;
    private List<Participation> participations = new ArrayList();
    private EnumSet<EventType> eventTypes = EnumSet.of(EventType.DEFAULT_EVENT);

    private int numCasualties;
    private List<String> registrationNumbers;

    private int stolenGoodsValue;
    private int numStolenGoods;

    private String assaultWeapon;

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

    public int getNumCasualties() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) {
            return numCasualties;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    public void setNumCasualties(int numCasualties) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) {
            this.numCasualties = numCasualties;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    public List<String> getRegistrationNumbers() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) {
            return registrationNumbers;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    public void setRegistrationNumbers(List<String> registrationNumbers) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) {
            this.registrationNumbers = registrationNumbers;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    public int getStolenGoodsValue() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) {
            return stolenGoodsValue;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    public void setStolenGoodsValue(int stolenGoodsValue) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) {
            this.stolenGoodsValue = stolenGoodsValue;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    public int getNumStolenGoods() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) {
            return getNumStolenGoods();
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    public void setNumStolenGoods(int numStolenGoods) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) {
            this.numStolenGoods = numStolenGoods;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    public String getAssaultWeapon() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.ASSAULT)) {
            return assaultWeapon;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.ASSAULT));
    }

    public void setAssaultWeapon(String assaultWeapon) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.ASSAULT)) {
            this.assaultWeapon = assaultWeapon;
        } else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.ASSAULT));
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
