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
    private int playerTurn;
    private int aiTurn;
    
    Grid grid= new Grid();
    
    public Game() {
        this.gameState = 0;
        this.playerTurn = 1; // Let H play first
        this.aiTurn = 0;
    }
    
    public void run() {
        System.out.println("Hi, let's play Battleship!\n");
        for (int i = 0; i < 6; i++) {//Insert ships.
            System.out.print("Enter the coordinates of your ship #" + i+1 + ":");
            xy = input.next();
            while (grid.getGrid(xy) != 0) {
                System.out.println("Sorry, coordinates already used. Try again.");
                System.out.print("Enter the coordinates of your ship #" + i+1 + ":");
                xy = input.next();
            }
            while (xy.charAt(0) < 'A' || xy.charAt(0) > 'H' || xy.charAt(1) < 1 || xy.charAt(1) > 8) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your ship #" + i+1 + ":");
                xy = input.next();
            }
            this.grid.insertGrid(xy, 1);
        }
        System.out.println("\n");
        for (int i = 0; i < 4; i++) {//Insert grenades.
            System.out.print("Enter the coordinates of your grenade #" + i+1 + ":");
            xy = input.next();
            while (grid.getGrid(xy) != 0) {
                System.out.println("Sorry, coordinates already used. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + i+1 + ":");
                xy = input.next();
            }
            while (xy.charAt(0) < 'A' || xy.charAt(0) > 'H' || xy.charAt(1) < 1 || xy.charAt(1) > 8) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + i+1 + ":");
                xy = input.next();
            }
            this.grid.insertGrid(xy, 2);
        }
        grid.showGrid();
    }
    
    public void endGame() { //0=ongoing, 1=Player wins, 2=AI wins
        switch (gameState) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
    }
    
        
}
