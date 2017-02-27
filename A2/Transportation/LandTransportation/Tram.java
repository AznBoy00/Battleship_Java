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
        super(t.getRouteNumber(), t.getStartOperationYear(), t.getLineName(), t.getDriverName(), t.getTicketPrice(), t.getNumOfStops());
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
        return "This Tram has " + this.getNumOfStops() + " stops, and costs " + this.getTicketPrice() + "$. It’s maximun speed is " + this.maxSpeed + "km/h. The route number is " + this.getRouteNumber() + ", it's name is " + this.getLineName() + ", driven by " + this.getDriverName() + " and was born in " + this.getStartOperationYear() + ".";
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
        if (Double.doubleToLongBits(this.getTicketPrice()) != Double.doubleToLongBits(other.getTicketPrice())) {
            return false;
        }
        if (this.getNumOfStops() != other.getNumOfStops()) {
            return false;
        }
        if (this.getRouteNumber() != other.getRouteNumber()) {
            return false;
        }
        if (this.getStartOperationYear() != other.getStartOperationYear()) {
            return false;
        }
        if (!this.getLineName().equals(other.getLineName())) {
            return false;
        }
        if (!this.getDriverName().equals(other.getDriverName())) {
            return false;
        }
        if (this.maxSpeed != other.maxSpeed) {
            return false;
        }
        return true;
    }
    
}
