package models;

import models.enums.OperationalGroupStatus;
import models.exceptions.InheritanceTypeException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.exceptions.ExceptionMessageProvider.GROUP_ID_TAKEN_MESSAGE;

public class OperationalGroup implements Serializable {

    private static final ArrayList<OperationalGroup> allOpGroups = new ArrayList<>();
    private static final Map<String, OperationalGroup> groupIDs = new HashMap<>();
    private final List<Response> responses = new ArrayList<>();
    private final List<Person> members = new ArrayList<>();
    private final String name;
    private final OperationalGroupStatus operationalGroupStatus;
    private PoliceVehicle vehicle;

    public OperationalGroup(String groupId, String name) throws Exception {
        this.setGroupID(groupId);
        this.name = name;
        this.operationalGroupStatus = OperationalGroupStatus.AWAITING_ORDERS;
        allOpGroups.add(this);
    }

    public void addResponse(Response response) {
        if (!responses.contains(response)) {
            this.responses.add(response);
            response.setOperationalGroup(this);
        }
    }

    public void addMember(Person member) throws InheritanceTypeException {
        if (!members.contains(member)) {
            this.members.add(member);
            member.setOperationalGroup(this);
        }
    }

    private void setGroupID(String groupId) throws Exception {
        if (groupIDs.containsKey(groupId)) {
            throw new Exception(String.format(GROUP_ID_TAKEN_MESSAGE, groupId));
        } else groupIDs.put(groupId, this);
    }

    public void setVehicle(PoliceVehicle vehicle) {
        if (this.vehicle != vehicle && this.vehicle != null) {
            this.vehicle.setOperationalGroup(null);
            this.vehicle = vehicle;
            this.vehicle.setOperationalGroup(this);
        }
        if (this.vehicle == null) {
            this.vehicle = vehicle;
            this.vehicle.setOperationalGroup(this);
        }
    }

    /**
     * The following methods are needed for demonstration purposes only.
     */
    @SuppressWarnings("unused")
    public int getNumGroups() {
        return allOpGroups.size();
    }

    @SuppressWarnings("unused")
    public OperationalGroupStatus getOperationalGroupStatus() {
        return operationalGroupStatus;
    }

    @SuppressWarnings("unused")
    public void getAllOpGroupInfo() {
        allOpGroups.forEach(System.out::println);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "OperationalGroup{" +
                "operationalGroupStatus=" + operationalGroupStatus +
                ", vehicle=" + vehicle +
                '}';
    }

    public void removeResponse(Response response) {
        responses.remove(response);
        response.resetOperationalGroup();
    }

    public void removeMember(Person member) {
        members.removeIf(member1 -> member1 == member);
    }



}
