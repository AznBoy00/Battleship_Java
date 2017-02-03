/*
 * Assignment 1
 * For COMP 249 Section PP - Winter 2017
 */
package battleship;

/**
 * This class defines the objects on the grid.
 * @author Kevin Lin - 40002383
 */
public class MapObject {
    private int type; //0=empty tile, 1=player ship, 2=player grenade, 3=ai ship, 4=ai grenade, 5=shot empty tile, 6=shot player ship, 7=shot player grenade, 8=shot ai ship, 9=shot ai grenade. (0 to 5 are initially shown as _ until it's destroyed.)
    private int owner; //0=null, 1=Human Player, 2=Computer.
    
    public MapObject(int type, int owner) {
        this.type = type;
        this.owner = owner;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
