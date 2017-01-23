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
        grid.destroyMapObject(xy);
        switch(grid.getGridType(xy)) {
            case 0:
                System.out.print("Nothing.\n");
                break;
            case 1:
                if (player.getShipCount() == 0) {
                    System.out.print("Ship hit.");
                    checkWin();
                } else {
                    System.out.print("Ship hit.\n");
                }
                player.setShipCount(player.getShipCount()-1);
                break;
            case 2:
                System.out.print("Boom! Grenade!\n");
                grenadeTouchDown(fromPlayer);
                break;
            case 3:
                if (ai.getShipCount() == 0) {
                    System.out.print("Ship hit.");
                    checkWin();
                } else {
                    System.out.print("Ship hit.\n");
                }
                ai.setShipCount(ai.getShipCount()-1);
                break;
            case 4:
                System.out.print("Boom! Grenade!\n");
                grenadeTouchDown(fromPlayer);
                break;
            case 5:
                System.out.print("Position already called.\n");
                break;    
            default:
                System.out.print("Error in shootRocket(String xy, int fromPlayer)\n");//E for error
                break;
        }
    }
    
    private void grenadeTouchDown(int player) {
        switch (player) {
            case 1:
                this.player.setTurnCount(this.player.getTurnCount()-1);
                this.ai.setTurnCount(this.ai.getTurnCount()+1);
                break;
            case 2:
                this.ai.setTurnCount(this.ai.getTurnCount()-1);
                this.player.setTurnCount(this.player.getTurnCount()+1);
                break;
            default:
                System.out.println("Error in grenadeTouchDown(int player)");
                break;
        }
    }
    
    public void startGame() {
        player.setTurnCount(1);
        while (onGoingGame) {
            if (player.getTurnCount() > 0) {
                player.myTurn(this);
                grid.showGrid();
                ai.setTurnCount(this.ai.getTurnCount()+1);
            }
            if (ai.getTurnCount() > 0) {
                ai.myTurn(grid, this);
                grid.showGrid();
                player.setTurnCount(this.player.getTurnCount()+1);
            }
        }
    }
    
    private void checkWin() {
        if (player.getShipCount() == 0) {
            System.out.print("\tI Win!\n");
        } else if (ai.getShipCount() == 0) {
            System.out.print("\tYou Win!\n");
        }
        this.onGoingGame = false;
    }
    
}
