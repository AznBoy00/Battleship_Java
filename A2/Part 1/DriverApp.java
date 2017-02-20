/*
    Assignment #2
    Part: Driver
    Written by: Kevin Lin - 40002383
*/

//PART2

import AirTransportation.*;
import InformationDesk.PublicTransportation;
import LandTransportation.*;
import WaterTransportation.*;

/**
 *
 * @author Kevin
 */

public class DriverApp {
    public static void main (String[] args) {
        PublicTransportation[] pTrans = new PublicTransportation[12];
        pTrans[0] = new AirCraft(AirCraft.Type.Airline, AirCraft.MaintenanceType.Monthly, 1000.99, 8);
        pTrans[1] = new PublicTransportation(50.01, 7);
        pTrans[2] = new CityBus(0L, 2017, "Downtown Way", "Best Driver", 5.26, 24);
        pTrans[3] = new Metro(8, "Montreal", 3, 2016, "The under East-West", "Raton Laveur", 7.04, 19);
        pTrans[4] = new Tram(150, 7, 2013, "The fast landline", "Dank Memer", 13.37, 98);
        pTrans[5] = new Ferry(1982, 1.01, 2);
        pTrans[6] = new AirCraft((AirCraft)pTrans[0]);
        pTrans[7] = new PublicTransportation(pTrans[1]);
        pTrans[8] = new CityBus((CityBus) pTrans[2]);
        pTrans[9] = new Metro((Metro) pTrans[3]);
        
        pTrans[9].setTicketPrice(999999.99);
        
        for (int i = 0; i < pTrans.length; i++) {
            System.out.println(pTrans[i].toString());
        }
        
        // Prints the toString from each object.
        
        for (int i = 0; i < 5; i++) {
            if(pTrans[i].equals(pTrans[i+5])) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        }
        
        // Check for low and high price of fair ticket and outputs info.
        
        double lowestPrice = pTrans[0].getTicketPrice();
        double highestPrice = pTrans[0].getTicketPrice();
        int arrayPosLow = 0;           
        int arrayPosHigh = 0;
        
        for (int i = 0; i < pTrans.length; i++) {            
            if (pTrans[i].getTicketPrice() < lowestPrice) {
                lowestPrice = pTrans[i].getTicketPrice();
                arrayPosLow = i;
            }
            if (pTrans[i].getTicketPrice() > highestPrice) {
                highestPrice = pTrans[i].getTicketPrice();
                arrayPosHigh = i;
            }
        }
        
        System.out.println("The lowest price transport information:");
        System.out.println(pTrans[arrayPosLow]);
        System.out.println("The highest price transport information:");
        System.out.println(pTrans[arrayPosHigh]);
        
    }
}
