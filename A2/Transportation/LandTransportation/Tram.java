/*
    Assignment #2
    Part: Tram
    Written by: Kevin Lin - 40002383
*/

package LandTransportation;

/**
 *
 * @author Kevin
 */
public class Tram extends CityBus {
    private int maxSpeed;
    
    /**
     * Default Constructor.
     */
    public Tram() {
        super();
    }
    
    /**
     * Copy Constructor
     * @param t Tram Object.
     */
    public Tram(Tram t) {
        super(t.routeNumber, t.startOperationYear, t.lineName, t.driverName, t.ticketPrice, t.numOfStops);
        this.maxSpeed = t.maxSpeed;
    }

    /**
     * Constructor taking parameters.
     * @param maxSpeed max speed.
     * @param routeNumber route number.
     * @param startOperationYear start operation year.
     * @param lineName line name.
     * @param driverName driver name.
     * @param ticketPrice ticket price.
     * @param numOfStops number of stops.
     */
    public Tram(int maxSpeed, long routeNumber, int startOperationYear, String lineName, String driverName, double ticketPrice, int numOfStops) {
        super(routeNumber, startOperationYear, lineName, driverName, ticketPrice, numOfStops);
        this.maxSpeed = maxSpeed;
    }

    /**
     * Getter for max speed.
     * @return max speed.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Setter for max speed.
     * @param maxSpeed max speed.
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "This Tram has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$. It’s maximun speed is " + this.maxSpeed + "km/h. The route number is " + this.routeNumber + ", it's name is " + this.lineName + ", driven by " + this.driverName + " and was born in " + this.startOperationYear + ".";
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
        final Tram other = (Tram) obj;
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
        if (this.maxSpeed != other.maxSpeed) {
            return false;
        }
        return true;
    }
    
}
