/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LandTransportation;

import InformationDesk.PublicTransportation;
import java.util.Objects;
/**
 *
 * @author Kevin
 */
public class CityBus extends PublicTransportation {
    protected long routeNumber;
    protected int startOperationYear;
    protected String lineName;
    protected String driverName;
    
    public CityBus(CityBus cb) {
        super(cb.ticketPrice, cb.numOfStops);
        this.driverName = cb.getDriverName();
        this.lineName = cb.getLineName();
        this.routeNumber = cb.getRouteNumber();
        this.startOperationYear = cb.getStartOperationYear();
    }
    public CityBus(long routeNumber, int startOperationYear, String lineName, String driverName, double ticketPrice, int numOfStops) {
        super(ticketPrice, numOfStops);
        this.routeNumber = routeNumber;
        this.startOperationYear = startOperationYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    public CityBus() {
        super();
    }

    public long getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(long routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getStartOperationYear() {
        return startOperationYear;
    }

    public void setStartOperationYear(int startOperationYear) {
        this.startOperationYear = startOperationYear;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getDriverName() {
        return driverName;
    }

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
