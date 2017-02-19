/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LandTransportation;

import java.util.Objects;

/**
 *
 * @author Kevin
 */
public class Metro extends CityBus {
    private int numOfVehicules;
    private String city;
    
    public Metro() {
        super();
    }
    
    public Metro(Metro m) {
        super(m.routeNumber, m.startOperationYear, m.lineName, m.driverName, m.ticketPrice, m.numOfStops);
        this.numOfVehicules = m.numOfVehicules;
        this.city = m.city;
    }

    

    public Metro(int numOfVehicules, String city, long routeNumber, int startOperationYear, String lineName, String driverName, double ticketPrice, int numOfStops) {
        super(routeNumber, startOperationYear, lineName, driverName, ticketPrice, numOfStops);
        this.numOfVehicules = numOfVehicules;
        this.city = city;
    }

    
    public int getNumOfVehicules() {
        return numOfVehicules;
    }

    public void setNumOfVehicules(int numOfVehicules) {
        this.numOfVehicules = numOfVehicules;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "This Metro has " + this.numOfStops + " stops, and costs " + this.ticketPrice + "$. It is located in " + this.city + ", and contains " + this.numOfVehicules + " vehicules. The route number is " + this.routeNumber + ", it's name is " + this.lineName + ", driven by " + this.driverName + " and was born in " + this.startOperationYear + ".";
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
        if (this.numOfVehicules != other.numOfVehicules) {
            return false;
        }
        if (!this.city.equals(other.city)) {
            return false;
        }
        return true;
    }
    
}
