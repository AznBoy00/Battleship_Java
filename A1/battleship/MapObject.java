/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Kevin
 */
public class MapObject {
    
    private String coordinates;
    /**
     * S=Player Ship, G=Player Grenade, s=AI Ship, G=AI Grenade, *=sinked object
     */
    private char objectType;
    private boolean isDestroyed;
    
    
    public void Ship(String coordinates) {
        this.coordinates = coordinates;
        this.isDestroyed = false;
    }
    
    public String getShip() {
        return coordinates;
    }
    
    public void destroyShip() {
        if (this.isDestroyed != true)
            this.isDestroyed = true;
    }
    
    public boolean isDestroyed() {
        if (isDestroyed == true)
            return true;
        return false;
    }
    
}
