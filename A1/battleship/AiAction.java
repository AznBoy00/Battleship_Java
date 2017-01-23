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
public class AiAction {
    private int turnCount;
    private int shipCount;

    public AiAction() {
        this.turnCount = 0;
        this.shipCount = 0;
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
    
    public void objectSetup(Grid grid, Game game) {
        String xy = xyGenerator();
        for (int i = 0; i < game.GAME_SHIP_COUNT; i++) {
            while (grid.getGridType(xyGenerator()) != 0) {
                xy = xyGenerator();
            }
            grid.insertGrid(xy, 1, 2);
            this.shipCount++;
        }
        for (int i = 0; i < game.GAME_GRENADE_COUNT; i++) {
            while (grid.getGridType(xyGenerator()) != 0) {
                xyGenerator();
            }
            grid.insertGrid(xy, 2, 2);
        }
        System.out.println("OK, the computer placed its ships and grenades at random. Let's Play.");
    }
    
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
    
    public void myTurn(Grid grid, Game game) {
        String xy = xyGenerator();
        while (grid.getGridType(xyGenerator()) < 6) {
            xyGenerator();
        }
        System.out.print("\nPosition of my rocket: " + xy + "\n");
        game.shootRocket(xy, 2);
        turnCount--;
    }
}
