/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        super(f.ticketPrice, f.numOfStops);
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
        return "This Ferry has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$. The ferry was built in " + this.buildYear + ".";
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
        
        if (Double.doubleToLongBits(this.ticketPrice) != Double.doubleToLongBits(other.ticketPrice)) {
            return false;
        }
        if (this.numOfStops != other.numOfStops) {
            return false;
        }
        if (this.buildYear != other.buildYear) {
            return false;
        }
        return true;
    } 
}
