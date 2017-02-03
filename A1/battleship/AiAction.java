/*
 * Assignment 1
 * For COMP 249 Section PP - Winter 2017
 */
package battleship;

/**
 * This class consists of an array of methods accessed by the computer in order to play the game.
 * @author Kevin Lin - 40002383
 */
public class AiAction {
    private int turnCount;
    private int shipCount;
    private int turnSkipped;

    /**
     * Default constructor for AiAction that will set everything to 0 initially.
     */
    public AiAction() {
        this.turnCount = 0;
        this.shipCount = 0;
        this.turnSkipped = 0;
    }

    /**
     * Getter method that gets the number of turn(s) skipped.
     * @return turnSkipped as an integer value.
     */
    public int getTurnSkipped() {
        return turnSkipped;
    }

    /**
     * Void setter method that sets the number of turns to skip.
     * @param accepts turnSkipped integer value to set the number of turns to skip. 
     */
    public void setTurnSkipped(int turnSkipped) {
        this.turnSkipped = turnSkipped;
    }

    /**
     * Getter method that gets the number of turn(s) count.
     * @return turnCount as an integer value.
     */
    public int getTurnCount() {
        return turnCount;
    }

    /**
     * Void method that sets the number of turn(s).
     * @param accepts turnCount integer value to set the number of turnCount. 
     */
    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    /**
     * Getter method that gets the number of ship(s)
     * @return shipCount as an integer value.
     */
    public int getShipCount() {
        return shipCount;
    }

    /**
     * Void setter method that sets the ship count by the accepted value.
     * @param shipCount as integer
     */
    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
    }
    
    /**
     * This void method makes the computer generate and place his ships and grenades in legal positions by passing through Grid and Game classes.
     * @param grid as an existing Grid class.
     * @param game as an existing Game class.
     */
    public void objectSetup(Grid grid, Game game) {
        String xy = xyGenerator();
        for (int i = 0; i < game.GAME_SHIP_COUNT; i++) {
            while (grid.getGridType(xy) != 0) {
                xy = xyGenerator();
            }
            grid.insertGrid(xy, 1, 2);
            this.shipCount++;
        }
        for (int i = 0; i < game.GAME_GRENADE_COUNT; i++) {
            while (grid.getGridType(xy) != 0) {
                xy = xyGenerator();
            }
            grid.insertGrid(xy, 2, 2);
        }
        System.out.println("OK, the computer placed its ships and grenades at random. Let's Play.");
    }
    
    /**
     * This String method will return a randomly generated coordinate while it will replace the first number by its corresponding letter through a switch statement.
     * @return String from generated numbers.
     */
    private String xyGenerator() {
        int firstLetter = (int)(Math.random()*8)+1;
        int y = (int)(Math.random()*8)+1;
        String x;
        switch (firstLetter) {
            case 1:
                x = "A";
                break;
            case 2:
                x = "B";
                break;
            case 3:
                x = "C";
                break;
            case 4:
                x = "D";
                break;
            case 5:
                x = "E";
                break;
            case 6:
                x = "F";
                break;
            case 7:
                x = "G";
                break;
            case 8:
                x = "H";
                break;
            default:
                x = "Z";
                break;
        }
        return x+y;
    }
    
    /**
     * 
     * @param grid as an existing instance of Grid.
     * @param game as an existing instance of Game.
     */
    public void myTurn(Grid grid, Game game) {
        String xy = xyGenerator();
        while (grid.getGridType(xy) > 4) {
            xy = xyGenerator();
        }
        System.out.print("\nPosition of my rocket: " + xy + "\n");
        game.shootRocket(xy, 2);
        turnCount--;
    }
}
