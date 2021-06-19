package models;

import models.enums.OperationalGroupStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.exceptions.ExceptionMessageProvider.GROUP_ID_TAKEN_MESSAGE;

public class OperationalGroup {
    private static Map<String, OperationalGroup> groupIDs = new HashMap<>();
    private List<Response> responses = new ArrayList<>();
    private List<Person> members = new ArrayList<>();
    private String name;
    private OperationalGroupStatus operationalGroupStatus;
    private PoliceVehicle vehicle;

    public OperationalGroup(String groupId, String name) throws Exception {
        this.setGroupID(groupId);
        this.name = name;
        this.operationalGroupStatus = OperationalGroupStatus.AWAITING_ORDERS;
    }

    public void addResponse(Response response) {
        if (!responses.contains(response)) {
            this.responses.add(response);
            response.setOperationalGroup(this);
        }
    }

    public void addMember(Person member) {
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
        responses.removeIf(response1 -> response1 == response);
    }
}
