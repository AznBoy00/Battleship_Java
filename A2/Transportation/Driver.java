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

public class Driver {
    public static void main (String[] args) {
        PublicTransportation[] pTrans;
        pTrans = new PublicTransportation[12];
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
            pTrans[10] = new Tram((Tram) pTrans[4]);
            pTrans[11] = new Ferry((Ferry) pTrans[5]);
        
        pTrans[9].setTicketPrice(999999.99);
        
        for (int i = 0; i < pTrans.length; i++) {
            System.out.println(pTrans[i].toString());
        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        // Display content of copied cityBus array.
        
        PublicTransportation[] newTrans = copyCityBus(pTrans);
        
        for (int i = 0; i < newTrans.length; i++) {
            System.out.println(newTrans[i]);
        }
    }
    
    /**
     * Copy the CityBus Objects into a new array of object.
     * @param p PublicTransportation array.
     * @return PublicTransportation array.
     */
    private static PublicTransportation[] copyCityBus(PublicTransportation[] p) {
        PublicTransportation[] pTransp = new PublicTransportation[p.length];
        for (int i = 0; i < pTransp.length; i++) {
            if (p[i].getClass() == CityBus.class) {
                pTransp[i] = new CityBus((CityBus)p[i]);
            }
        }
        return pTransp;
    }
}
