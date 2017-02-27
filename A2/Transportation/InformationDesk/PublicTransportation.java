/*
    Assignment #2
    Part: PublicTransportation
    Written by: Kevin Lin - 40002383
*/

package InformationDesk;

/**
 *
 * @author Kevin
 */
public class PublicTransportation {
    private double ticketPrice;
    private int numOfStops;
    
    /**
     * Default Constructor
     */
    public PublicTransportation() {
    }
    /**
     * Copy Constructor
     * @param pt PublicTransportation Object
     */
    public PublicTransportation(PublicTransportation pt) {
        this.ticketPrice = pt.ticketPrice;
        this.numOfStops = pt.numOfStops;
    }
    /**
     * Constructor taking ticketPrice and numOfStops
     * @param ticketPrice ticket price
     * @param numOfStops number of stops
     */
    public PublicTransportation(double ticketPrice, int numOfStops) {
        this.ticketPrice = ticketPrice;
        this.numOfStops = numOfStops;
    }
    /**
     * Getter for ticketPrice
     * @return price of ticket.
     */
    public double getTicketPrice() {
        return ticketPrice;
    }
    /**
     * Setter for ticketPrice
     * @param ticketPrice price of ticket.
     */
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    /**
     * Getter for numOfStops.
     * @return number of stops.
     */
    public int getNumOfStops() {
        return numOfStops;
    }
    /**
     * Setter for numOfStops
     * @param numOfStops number of stops.
     */
    public void setNumOfStops(int numOfStops) {
        this.numOfStops = numOfStops;
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
        final PublicTransportation other = (PublicTransportation) obj;
        
        if (Double.doubleToLongBits(this.ticketPrice) != Double.doubleToLongBits(other.ticketPrice)) {
            return false;
        }
        if (this.numOfStops != other.numOfStops) {
            return false;
        }
        return true;
        }

    /**
     * String representation for this class.
     * @return description of the class.
     */
    @Override
    public String toString() {
        return "This PublicTransportation has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$.";
    }
}
