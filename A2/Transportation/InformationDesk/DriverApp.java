/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformationDesk;

import AirTransportation.*;
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
        pTrans[10] = new Tram((Tram) pTrans[4]);
        pTrans[11] = new Ferry((Ferry) pTrans[5]);
        
        pTrans[9].setTicketPrice(999999.99);
        
        for (int i = 0; i < pTrans.length; i++) {
            System.out.println(pTrans[i].toString());
        }
        
        for (int i = 0; i < 6; i++) {
            if(pTrans[i].equals(pTrans[i+6])) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        }
        
    }
}
