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
public class Game {
    private boolean onGoingGame;
    public final int GAME_SHIP_COUNT = 6;
    public final int GAME_GRENADE_COUNT = 4;
    
    private Grid grid;
    private PlayerAction player;
    private AiAction ai;
    
    public Game() {
        this.onGoingGame = true;
        this.grid = new Grid();
        this.player = new PlayerAction();
        this.ai = new AiAction();
    }
    
    public void run() {
        System.out.println("Hi, let's play Battleship!\n");
        player.objectSetup(grid, this);
        ai.objectSetup(grid, this);
        startGame();
    }

    public void shootRocket(String xy, int fromPlayer) {
        switch(grid.getGridType(xy)) {
            case 0:
                System.out.print("Nothing.\n");
                break;
            case 1:
                player.setShipCount(player.getShipCount()-1);
                if (player.getShipCount() == 0) {
                    System.out.print("Ship hit.\tYou win!");
                } else {
                    System.out.print("Ship hit.\n");
                }
                break;
            case 2:
                System.out.print("Boom! Grenade!\n");
                grenadeTouchDown(xy, fromPlayer);
                break;
            case 3:
                ai.setShipCount(ai.getShipCount()-1);
                if (ai.getShipCount() == 0) {
                    System.out.print("Ship hit.\tI win!");
                } else {
                    System.out.print("Ship hit.\n");
                }
                break;
            case 4:
                System.out.print("Boom! Grenade!\n");
                grenadeTouchDown(xy, fromPlayer);
                break;
            default:
                //System.out.print("Error in shootRocket(String xy, int fromPlayer)\n");//For Debug Purpose
                System.out.println("Position already called.");
                break;
        }
        grid.destroyMapObject(xy);
    }
    
    private void grenadeTouchDown(String xy, int fromPlayer) {
        switch (fromPlayer) {
            case 1:
                if (grid.getGridOwner(xy) == 2) {
                    player.setTurnCount(player.getTurnCount()-1);
                    player.setTurnSkipped(player.getTurnSkipped()+1);
                    ai.setTurnCount(ai.getTurnCount()+1);
                }
                break;
            case 2:
                if (grid.getGridOwner(xy) == 1) {
                    ai.setTurnCount(ai.getTurnCount()-1);
                    ai.setTurnSkipped(ai.getTurnSkipped()+1);
                    player.setTurnCount(player.getTurnCount()+1);
                }
                break;
            default:
                System.out.println("Error in grenadeTouchDown(int player)");
                break;
        }
    }
    
    private void startGame() {
        player.setTurnCount(1);
        while (onGoingGame) {
            if (player.getTurnCount() > 0) {
                player.myTurn(this);
                grid.showGrid();
                ai.setTurnCount(this.ai.getTurnCount()+1);
                checkWin();
            } else if (ai.getTurnCount() > 0) {
                ai.myTurn(grid, this);
                grid.showGrid();
                player.setTurnCount(this.player.getTurnCount()+1);
                checkWin();
            }
        }
    }
    
    private void checkWin() {
        if (player.getShipCount() == 0 || ai.getShipCount() == 0) {
            System.out.println("The player has missed: " + player.getTurnSkipped() + " turns due to hitting a grenade.");
            System.out.println("The computer has missed: " + ai.getTurnSkipped() + " turns due to hitting a grenade.");
            grid.revealGrid();
            this.onGoingGame = false;
        }
    }
    
}
