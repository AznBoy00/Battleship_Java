/*
 * Assignment 1
 * For COMP 249 Section PP - Winter 2017
 */
package battleship;

import java.util.Scanner;

/**
 * This class manages the actions inputed by the player on the game class.
 * @author Kevin Lin - 40002383
 */
public class PlayerAction {
    
    Scanner input = new Scanner(System.in);
    private String xy;
    private int turnCount;
    private int shipCount;
    private int turnSkipped;
    
    /**
     * Default constructor for PlayerAction in which will set the turnCount, shipCount and turnSkipped to 0 as an initial value.
     */
    public PlayerAction() {
        this.turnCount = 0;
        this.shipCount = 0;
        this.turnSkipped = 0;
    }
    
    /**
     * This void method will prompt the player to setup his mapObjects such as his/her ships and grenades on inputed coordinates while the method checks for legal inputs.
     * @param grid
     * @param game 
     */
    public void objectSetup(Grid grid, Game game) {
        for (int i = 0; i < game.GAME_SHIP_COUNT; i++) {//Insert ships.
            System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
            xy = input.nextLine();
            while (checkInput(xy)) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            while (grid.getGridType(xy) != 0) {
                System.out.println("Sorry, coordinates already used. Try again.");
                System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            grid.insertGrid(xy, 1, 1);
            this.shipCount++;
        }
        System.out.println();
        for (int i = 0; i < game.GAME_GRENADE_COUNT; i++) {//Insert grenades.
            System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
            xy = input.nextLine();
            while (checkInput(xy)) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            while (checkInput(xy) & grid.getGridType(xy) != 0) {
                System.out.println("Sorry, coordinates already used. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            grid.insertGrid(xy, 2, 1);
        }
    }
    
    /**
     * This method is dedicated to check a users input in which will make sure that his/her input is valid.
     * @param xy as a String representing the coordinates inputed.
     * @return a boolean which will will be true if the input is a legal input and false if it is not.
     */
    private boolean checkInput(String xy) {
        if (xy.length() != 2)
            return true;
        xy = xy.toUpperCase();
        String y = xy.substring(1, 2);
        if (xy.charAt(0) < 'A')
            return true;
        else if (xy.charAt(0) > 'H')
            return true;
        else if (Integer.parseInt(y) < 1)
            return true;
        else if (Integer.parseInt(y) > 8)
            return true;
        else
            return false;
    }

    /**
     * Getter method in which will return the turnCount from the player.
     * @return turnCount as an integer.
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
     * This void method will allow the player to be prompted on the console in order to input a coordinate in which the player will want to shoot his/her rocket.
     * It will also check if the inputed coordinate is valid by going through the checkInput() method.
     * @param game 
     */
    public void myTurn(Game game) {
        System.out.print("\nPosition of your rocket: ");
        xy = input.nextLine();
        while (checkInput(xy)) {
            System.out.println("Sorry, coordinates is invalid.");
            System.out.print("Position of my rocket: ");
            xy = input.nextLine();
        }
        game.shootRocket(xy, 1);
        turnCount--;
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
}
