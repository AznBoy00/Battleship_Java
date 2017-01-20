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
public class GridHandler {
    Ship ship = new Ship();
    Scanner input = new Scanner(System.in);
    private Ship[][] grid = new Ship[9][9];
    private boolean isDestroyed;

    public GridHandler() {
    }
    
    public void createGrid() {
        grid [0][0] = ' ';
        for (int i = 0; i < 8; i++) {
            grid [0][i+1] = (char)(65+i);
        }
        for (int i = 0; i < 8; i++) {
            grid [i+1][0] = (char)(49+i);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid [i+1][j+1] = ' ';
            }
        }
    }
    
    public void integrateShips() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ship.getShip() != null)
                    
            }
        }
    }
    
    public void showGrid() {
        System.out.println("__________________");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("\n__________________");
        }
    }
    
}
