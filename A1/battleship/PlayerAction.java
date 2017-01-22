/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class PlayerAction {
    
    Scanner input = new Scanner(System.in);
    private String xy;
    private int turnCount;
    private int shipCount;

    public PlayerAction() {
    }
    
    public void playerObjectSetup() {
        for (int i = 0; i < 6; i++) {//Insert ships.
            System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
            xy = input.nextLine();
            while (checkInput(xy)) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your ship #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            while (checkInput(xy) && grid.getGrid(xy) != 0) {
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
            while (checkInput(xy)) {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            while (checkInput(xy) && grid.getGrid(xy) != 0) {
                System.out.println("Sorry, coordinates already used. Try again.");
                System.out.print("Enter the coordinates of your grenade #" + (i+1) + ": ");
                xy = input.nextLine();
            }
            this.grid.insertGrid(xy, 2);
        }
    }
    
    private boolean checkInput(String xy) {
        String y = xy.substring(1, 2);
        if (xy.length() != 2)
            return true;
        else if (xy.charAt(0) < 'A')
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
}
