package models;

import models.enums.OperationalGroupStatus;

import java.util.HashMap;
import java.util.Map;

public class OperationalGroup {
    private static Map<String, OperationalGroup> groupIDs = new HashMap<>();
    private OperationalGroupStatus operationalGroupStatus;
    private PoliceVehicle vehicle;

    public OperationalGroup(String groupId) throws Exception {
        this.setGroupID(groupId);
        this.operationalGroupStatus = OperationalGroupStatus.AWAITING_ORDERS;
    }

    private void setGroupID(String groupId) throws Exception {
        if (groupIDs.containsKey(groupId)) {
            throw new Exception("The ID is taken");
        } else groupIDs.put(groupId, this);
    }

    public void setVehicle(PoliceVehicle vehicle) {

    }

    @Override
    public String toString() {
        return "OperationalGroup{" +
                "operationalGroupStatus=" + operationalGroupStatus +
                ", vehicle=" + vehicle +
                '}';
    }
}
