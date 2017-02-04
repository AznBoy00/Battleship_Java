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
    /*
     * The variables below are number coded in order to ease the program's code to function more accurately instead of using specific string names.
     * This method reduces significantly the sizes of classes in the project.
     * 
     * type
     * 0 = empty tile
     * 1 = player ship
     * 2 = player grenade
     * 3 = ai ship
     * 4 = ai grenade
     * 5 = shot empty tile
     * (0 to 5 are initially shown as _ until it's destroyed.)
     * 6 = shot player ship
     * 7 = shot player grenade
     * 8 = shot ai ship
     * 9 = shot ai grenade
     * 
     * owner
     * 0 = Unassigned player
     * 1 = Human Player
     * 2 = Computer
     */
    private int type; //
    private int owner; //
    
    /**
     * Constructor that creates a mapObject with 2 properties (type, owner).
     * @param type as an integer value.
     * @param owner as an integer value.
     */
    public MapObject(int type, int owner) {
        this.type = type;
        this.owner = owner;
    }

    /**
     * Getter method in which returns the type of the mapObject as an integer value.
     * @return type as integer value.
     */
    public int getType() {
        return type;
    }

    /**
     * Setter method in which sets the type of the mapObject by accepting an integer.
     * @param type as an integer.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Getter method in which returns the owner's ID (Refer to chart above) of the mapObject as an integer value.
     * @return owner as integer value.
     */
    public int getOwner() {
        return owner;
    }

    /**
     * Setter method in which sets the owner's ID (Refer to chart above) of the mapObject by accepting an integer.
     * @param owner as an integer.
     */
    public void setOwner(int owner) {
        this.owner = owner;
    }
}
