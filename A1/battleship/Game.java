/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.*;

/**
 *
 * @author Kevin
 */
public class Game {

    Scanner input = new Scanner(System.in);
    private String xy;
    private int gameState = 0; //0=ongoing, 1=Player wins, 2=AI wins
    
    //Human Player
    private int playerTurn;
    private int playerShips;
    
    //Computer
    private int aiTurn;
    private int aiShips;
    
    Grid grid= new Grid();
    
    public Game() {
        this.gameState = 0;
        this.playerTurn = 1; // Let H play first
        this.playerShips = 6;
        this.aiTurn = 0;
        this.aiShips = 6;
    }
    
    public void run() {
        System.out.println("Hi, let's play Battleship!\n");
        for (int i = 0; i < 6; i++) {//Insert ships.
            System.out.print("Enter the coordinates of your ship #" + i+1 + ": ");
            xy = input.nextLine();
            while (checkCoordinate(xy)) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            while (grid.getGrid(xy) != 0) {
                System.out.println("Sorry, coordinates already used. Try again.");
                System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            this.grid.insertGrid(xy, 1);
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {//Insert grenades.
            System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
            xy = input.nextLine();
            while (checkCoordinate(xy)) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            while (grid.getGrid(xy) != 0) {
                System.out.println("Sorry, coordinates already used. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            this.grid.insertGrid(xy, 2);
        }
        System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
        System.out.print("\nPosition of your rocket: ");
        input.nextLine();
        shootRocket(xy);
        grid.showGrid();
    }
    
    private boolean checkCoordinate(String xy) {
        if (xy.charAt(0) < 'A')
            return true;
        else if (xy.charAt(0) > 'H')
            return true;
        else if (xy.charAt(1) < '1')
            return true;
        else if (xy.charAt(1) > '8')
            return true;
        else
            return false;
    }
    
    public void shootRocket(String xy) {
        int x = convertLetter(xy);
        int y = Integer.parseInt(xy.substring(1, 2)) - 1;
        switch(grid.getGrid(xy)) {
            case 0:
                System.out.print("Nothing.");
                break;
            case 1:
                System.out.print("Ship hit.");
                break;
            case 2:
                System.out.print("Boom! Grenade!");
                break;
            case 3:
                System.out.print("Ship hit.");
                break;
            case 4:
                System.out.print("Boom! Grenade!");
                break;
            case 5:
                System.out.print("Position already called.");
                break;    
            default:
                System.out.print("Error.");//E for error
                break;
        }
        grid.grid[x][y].setType(5);
    }
    
    private int convertLetter(String xy) {
        xy = xy.toUpperCase();
        char x = xy.charAt(0);
        switch (x) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            default:
                return -1;
        }
    }

}
