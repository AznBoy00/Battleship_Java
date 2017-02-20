/*
    Assignment #2
    Part: CityBus
    Written by: Kevin Lin - 40002383
*/

package LandTransportation;

import InformationDesk.PublicTransportation;

/**
 *
 * @author Kevin
 */
public class CityBus extends PublicTransportation {
    protected long routeNumber;
    protected int startOperationYear;
    protected String lineName;
    protected String driverName;
    
    /**
     * Copy Constructor
     * @param cb CityBus Object
     */
    public CityBus(CityBus cb) {
        super(cb.ticketPrice, cb.numOfStops);
        this.driverName = cb.getDriverName();
        this.lineName = cb.getLineName();
        this.routeNumber = cb.getRouteNumber();
        this.startOperationYear = cb.getStartOperationYear();
    }
    
    /**
     * Construction taking parameters.
     * @param routeNumber route number.
     * @param startOperationYear start operation year.
     * @param lineName line name.
     * @param driverName driver name.
     * @param ticketPrice ticket price.
     * @param numOfStops number of stops.
     */
    public CityBus(long routeNumber, int startOperationYear, String lineName, String driverName, double ticketPrice, int numOfStops) {
        super(ticketPrice, numOfStops);
        this.routeNumber = routeNumber;
        this.startOperationYear = startOperationYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    /**
     * Default Constructor
     */
    public CityBus() {
        super();
    }

    /**
     * Getter for routeNumber.
     * @return route number.
     */
    public long getRouteNumber() {
        return routeNumber;
    }

    /**
     * Setter for routeNumber.
     * @param routeNumber route number.
     */
    public void setRouteNumber(long routeNumber) {
        this.routeNumber = routeNumber;
    }

    /**
     * Getter for startOperationYear.
     * @return start operation year.
     */
    public int getStartOperationYear() {
        return startOperationYear;
    }

    /**
     * Setter for startOperationYear.
     * @param startOperationYear start operation year.
     */
    public void setStartOperationYear(int startOperationYear) {
        this.startOperationYear = startOperationYear;
    }

    /**
     * Getter for lineName.
     * @return line name.
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * Setter for lineName.
     * @param lineName line name. 
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * Getter for driverName.
     * @return driver name.
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Setter for driverName.
     * @param driverName driver name.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    @Override
    public String toString() {
        return "This CityBus has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$. The route number is " + this.routeNumber + ", it's name is " + this.lineName + ", driven by " + this.driverName + " and was born in " + this.startOperationYear + ".";
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
        final CityBus other = (CityBus) obj;
        
        if (Double.doubleToLongBits(this.ticketPrice) != Double.doubleToLongBits(other.ticketPrice)) {
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
        return true;
    }
    
}
