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

    private boolean isDestroyed;
    private int type; //0=empty, 1=player ship, 2=player grenade, 3=ai ship, 4=ai grenade, 5=has been shot.

    public MapObject(int type) {
        this.type = type;
        this.isDestroyed = false;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    
}
