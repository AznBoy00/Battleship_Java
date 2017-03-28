/*
    Assignment #2
    Part: Metro
    Written by: Kevin Lin - 40002383
*/

package LandTransportation;

import java.util.Objects;

/**
 *
 * @author Kevin
 */
public class Metro extends CityBus {
    private int numOfVehicles;
    private String city;
    
    /**
     * Default Constructor
     */
    public Metro() {
        super();
    }
    
    /**
     * Copy Constructor
     * @param m Metro Object
     */
    public Metro(Metro m) {
        super(m.routeNumber, m.startOperationYear, m.lineName, m.driverName, m.ticketPrice, m.numOfStops);
        this.numOfVehicles = m.numOfVehicles;
        this.city = m.city;
    }

    /**
     * Constructor taking parameters.
     * @param numOfVehicles number of vehicles.
     * @param city city.
     * @param routeNumber route number.
     * @param startOperationYear start operation year.
     * @param lineName line name.
     * @param driverName driver name.
     * @param ticketPrice ticket price.
     * @param numOfStops number of stops.
     */
    public Metro(int numOfVehicles, String city, long routeNumber, int startOperationYear, String lineName, String driverName, double ticketPrice, int numOfStops) {
        super(routeNumber, startOperationYear, lineName, driverName, ticketPrice, numOfStops);
        this.numOfVehicles = numOfVehicles;
        this.city = city;
    }
    
    /**
     * Getter for numOfVehicles.
     * @return number of vehicles.
     */
    public int getNumOfVehicles() {
        return numOfVehicles;
    }

    /**
     * Setter for numOfVehicles.
     * @param numOfVehicles number of vehicles.
     */
    public void setNumOfVehicles(int numOfVehicles) {
        this.numOfVehicles = numOfVehicles;
    }

    /**
     * Getter for city.
     * @return city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for city.
     * @param city city.
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "This Metro has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$. It is located in " + this.city + ", and contains " + this.numOfVehicles + " vehicles. The route number is " + this.routeNumber + ", it's name is " + this.lineName + ", driven by " + this.driverName + " and was born in " + this.startOperationYear + ".";
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
        final Metro other = (Metro) obj;
        if (Double.doubleToLongBits(this.ticketPrice) != Double.doubleToLongBits(other.ticketPrice)) {
            return false;
        }
        if (this.numOfStops != other.numOfStops) {
            return false;
        }
        if (this.numOfStops != other.numOfStops) {
            return false;
        }
        if (this.routeNumber != other.routeNumber) {
            return false;
        }
        if (this.startOperationYear != other.startOperationYear) {
            return false;
        }
        if (!this.lineName.equals(other.lineName)) {
            return false;
        }
        if (!this.driverName.equals(other.driverName)) {
            return false;
        }
        if (this.numOfVehicles != other.numOfVehicles) {
            return false;
        }
        if (!this.city.equals(other.city)) {
            return false;
        }
        return true;
    }
    
}
