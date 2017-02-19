/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LandTransportation;

/**
 *
 * @author Kevin
 */
public class Tram extends CityBus {
    private int maxSpeed;
    
    public Tram() {
        super();
    }
    
    public Tram(Tram t) {
        super(t.routeNumber, t.startOperationYear, t.lineName, t.driverName, t.ticketPrice, t.numOfStops);
        this.maxSpeed = t.maxSpeed;
    }

    public Tram(int maxSpeed, long routeNumber, int startOperationYear, String lineName, String driverName, double ticketPrice, int numOfStops) {
        super(routeNumber, startOperationYear, lineName, driverName, ticketPrice, numOfStops);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

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
