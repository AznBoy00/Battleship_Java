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
public class Ship {
    
    private String coordinates;
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
