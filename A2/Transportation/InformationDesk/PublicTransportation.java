/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformationDesk;

/**
 *
 * @author Kevin
 */
public class PublicTransportation {
    protected double ticketPrice;
    protected int numOfStops;
    
    public PublicTransportation() {
    }
    
    public PublicTransportation(PublicTransportation pt) {
        this.ticketPrice = pt.ticketPrice;
        this.numOfStops = pt.numOfStops;
    }

    public PublicTransportation(double ticketPrice, int numOfStops) {
        this.ticketPrice = ticketPrice;
        this.numOfStops = numOfStops;
    }
    
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getNumOfStops() {
        return numOfStops;
    }

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

    @Override
    public String toString() {
        return "This PublicTransportation has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$.";
    }
}
