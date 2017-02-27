/*
    Assignment #2
    Part: Ferry
    Written by: Kevin Lin - 40002383
*/

package WaterTransportation;

import InformationDesk.PublicTransportation;

/**
 *
 * @author Kevin
 */
public class Ferry extends PublicTransportation{
    private int buildYear;
    
    public Ferry(Ferry f) {
        super(f.getTicketPrice(), f.getNumOfStops());
        this.buildYear = f.buildYear;
    }

    public Ferry(int buildYear, double ticketPrice, int numOfStops) {
        super(ticketPrice, numOfStops);
        this.buildYear = buildYear;
    }

    public Ferry() {
        super();
    }
    
    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }
    
    @Override
    public String toString() {
        return "This Ferry has " + this.getNumOfStops() + " stops, and costs " + this.getTicketPrice() + "$. The ferry was built in " + this.buildYear + ".";
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
        final Ferry other = (Ferry) obj;
        
        if (Double.doubleToLongBits(this.getTicketPrice()) != Double.doubleToLongBits(other.getTicketPrice())) {
            return false;
        }
        if (this.getNumOfStops() != other.getNumOfStops()) {
            return false;
        }
        if (this.buildYear != other.buildYear) {
            return false;
        }
        return true;
    } 
}
