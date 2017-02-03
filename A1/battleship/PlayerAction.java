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
    
    public PlayerAction() {
        this.turnCount = 0;
        this.shipCount = 0;
        this.turnSkipped = 0;
    }
    
    public void objectSetup(Grid grid, Game game) {
        for (int i = 0; i < game.GAME_SHIP_COUNT; i++) {//Insert ships.
            System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
            xy = input.nextLine();
            while (checkInput(xy)) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            while (checkInput(xy) & grid.getGridType(xy) != 0) {
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

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getShipCount() {
        return shipCount;
    }

    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
    }
    
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

    public int getTurnSkipped() {
        return turnSkipped;
    }

    public void setTurnSkipped(int turnSkipped) {
        this.turnSkipped = turnSkipped;
    }
}
