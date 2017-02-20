/*
    Assignment #2
    Part: Aircraft
    Written by: Kevin Lin - 40002383
*/

package AirTransportation;

import InformationDesk.PublicTransportation;
import java.util.Objects;

/**
 *
 * @author Kevin Lin
 */
public class AirCraft extends PublicTransportation {
    
    private Type aircraftType;
    private MaintenanceType maintenanceType;

    
    /**
     * Default Constructor
     */
    public AirCraft() {
        super();
    }
    
    /**
     * Copy Constructor.
     * @param ac AirCraft object.
     */
    public AirCraft(AirCraft ac) {
        super(ac.getTicketPrice(), ac.getNumOfStops());
        aircraftType = ac.aircraftType;
        maintenanceType = ac.maintenanceType;
    }

    /**
     * Constructor taking parameters.
     * @param aircraftType aircraft type.
     * @param maintenanceType maintenance type.
     * @param ticketPrice ticket price.
     * @param numOfStops number of stops.
     */
    public AirCraft(Type aircraftType, MaintenanceType maintenanceType, double ticketPrice, int numOfStops) {
        super(ticketPrice, numOfStops);
        this.aircraftType = aircraftType;
        this.maintenanceType = maintenanceType;
    }
    
    /**
     * Enumeration of the types from AirCraft.
     */
    public enum Type {
        Helicopter, Airline, Glider, Balloon
    }
    
    /**
     * Enumeration of the types of maintenance.
     */
    public enum MaintenanceType {
        Weekly, Monthly, Yearly
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AirCraft other = (AirCraft) obj;
        
        if (Double.doubleToLongBits(this.ticketPrice) != Double.doubleToLongBits(other.ticketPrice)) {
            return false;
        }
        if (this.numOfStops != other.numOfStops) {
            return false;
        }
        
        if (this.aircraftType != other.aircraftType) {
            return false;
        }
        if (this.maintenanceType != other.maintenanceType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "This AirCraft has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$. The aircraft is a " + this.aircraftType + " and is maintained " + this.maintenanceType + ".";
    }
}
