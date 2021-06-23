package models;

import models.enums.EventType;
import models.exceptions.InheritanceTypeException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static models.exceptions.ExceptionMessageProvider.TYPE_ERROR_MESSAGE;

public class Event implements Serializable {

    private final LocalDate date;
    private final LocalTime time;
    private final String location;
    private final List<String> securedEvidence = new ArrayList<>();
    private final List<String> casualtyIds = new ArrayList<>();

    private int numCasualties;
    private List<String> registrationNumbers = new ArrayList<>();

    private int stolenGoodsValue;
    private int numStolenGoods;

    private final List<Participation> participations = new ArrayList<>();
    private final List<Response> responses = new ArrayList<>();
    private final EnumSet<EventType> eventTypes = EnumSet.of(EventType.DEFAULT_EVENT);

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

    public void addResponse(Response response) {
        if (!responses.contains(response)) {
            this.responses.add(response);
            response.setEvent(this);
        }
    }

    /**
     * The following methods are required for demonstrations purposes only.
     */

    @SuppressWarnings("unused")
    public List<String> getSecuredEvidence() {
        return securedEvidence;
    }

    @SuppressWarnings("unused")
    public List<String> getCasualtyIds() {
        return casualtyIds;
    }

    @SuppressWarnings("unused")
    public int getNumCasualties() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) return numCasualties;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    @SuppressWarnings("unused")
    public void setNumCasualties(int numCasualties) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) this.numCasualties = numCasualties;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    @SuppressWarnings("unused")
    public List<String> getRegistrationNumbers() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) return registrationNumbers;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    @SuppressWarnings("unused")
    public void setRegistrationNumbers(List<String> registrationNumbers) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.CAR_ACCIDENT)) this.registrationNumbers = registrationNumbers;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.CAR_ACCIDENT));
    }

    @SuppressWarnings("unused")
    public int getStolenGoodsValue() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) return stolenGoodsValue;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    @SuppressWarnings("unused")
    public void setStolenGoodsValue(int stolenGoodsValue) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) this.stolenGoodsValue = stolenGoodsValue;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    @SuppressWarnings("unused")
    public int getNumStolenGoods() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) return numStolenGoods;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    @SuppressWarnings("unused")
    public void setNumStolenGoods(int numStolenGoods) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.THEFT)) this.numStolenGoods = numStolenGoods;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.THEFT));
    }

    @SuppressWarnings("unused")
    public String getAssaultWeapon() throws InheritanceTypeException {
        if (eventTypes.contains(EventType.ASSAULT)) return assaultWeapon;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.ASSAULT));
    }


    @SuppressWarnings("unused")
    public void setAssaultWeapon(String assaultWeapon) throws InheritanceTypeException {
        if (eventTypes.contains(EventType.ASSAULT)) this.assaultWeapon = assaultWeapon;
        else throw new InheritanceTypeException(String.format(TYPE_ERROR_MESSAGE, EventType.ASSAULT));
    }

    @Override
    public String toString() {
        // If any other optional attribute is ever needed in toString(), it can be processed the same way:
        String assaultWeaponMsg = this.assaultWeapon == null ? "Not an assault" : this.assaultWeapon;
        return "Event{" +
                "date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", participationsSize=" + participations.size() +
                ", assaultWeapon" + assaultWeaponMsg +
                '}';
    }


    public void removeResponse(Response response) {
        responses.removeIf(response1 -> response1 == response);
    }
}
