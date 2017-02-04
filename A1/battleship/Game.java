/*
 * Assignment 1
 * For COMP 249 Section PP - Winter 2017
 */
package battleship;

/**
 * This class manages anything that happens while the game is running.
 * @author Kevin Lin - 40002383
 */
public class Game {
    private boolean onGoingGame;
    public final int GAME_SHIP_COUNT = 6;
    public final int GAME_GRENADE_COUNT = 4;
    
    private Grid grid;
    private PlayerAction player;
    private AiAction ai;
    
    /**
     * Default constructor to initiate more constructors to start the game.
     */
    public Game() {
        this.onGoingGame = true;
        this.grid = new Grid();
        this.player = new PlayerAction();
        this.ai = new AiAction();
    }
    
    /**
     * Method in which will startup the game with a welcome, by prompting the player to setup his objects, by making the computer setting up his objects and then call the startGame() method.
     */
    public void run() {
        System.out.println("Hi, let's play Battleship!\n");
        player.objectSetup(grid, this);
        ai.objectSetup(grid, this);
        startGame();
    }

    /**
     * Method in which coordinates the rocket to trigger the player's action and will trigger another method depending on the type of the grid.
     * @param xy as a String representing the coordinates.
     * @param fromPlayer as an integer corresponding the the player who placed this action.
     */
    public void shootRocket(String xy, int fromPlayer) {
        switch(grid.getGridType(xy)) {
            case 0:
                System.out.print("Nothing.\n");
                break;
            case 1:
                player.setShipCount(player.getShipCount()-1);
                if (player.getShipCount() == 0) {
                    System.out.println("Ship hit.\tYou win!");
                } else {
                    System.out.println("Ship hit.");
                }
                break;
            case 2:
                System.out.println("Boom! Grenade!");
                grenadeTouchDown(xy, fromPlayer);
                break;
            case 3:
                ai.setShipCount(ai.getShipCount()-1);
                if (ai.getShipCount() == 0) {
                    System.out.println("Ship hit.\tI win!");
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
    
    /**
     * Void method in which activates when a player hits a grenade in an xy coordinate.
     * @param xy x & y coordinates
     * @param fromPlayer turn player
     */
    private void grenadeTouchDown(String xy, int fromPlayer) {
        switch (fromPlayer) {
            case 1:
                if (grid.getGridOwner(xy) == 2) {
                    player.setTurnCount(player.getTurnCount()-1);
                    player.setTurnSkipped(player.getTurnSkipped()+1);
                    ai.setTurnCount(ai.getTurnCount()+1);
                } else {
                    System.out.println("You shot at your own grenade...");
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
                } else {
                    System.out.println("I shot at my own grenade...");
                    ai.setTurnCount(ai.getTurnCount()-1);
                    ai.setTurnSkipped(ai.getTurnSkipped()+1);
                    player.setTurnCount(player.getTurnCount()+1);
                }
                break;
            default:
                System.out.println("Error in grenadeTouchDown(int fromPlayer)");// DEBUG PURPOSE
                break;
        }
    }
    
    /**
     * Private void method in which starts the game after all players have placed all their mapObjects on the grid.
     */
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
    
    /**
     * Private void method in which checks for a win condition while the game is going on (onGoingGame = true) after every player completes a turn.
     */
    private void checkWin() {
        if (player.getShipCount() == 0 || ai.getShipCount() == 0) {
            System.out.println("\nThe player has missed: " + player.getTurnSkipped() + " turns due to hitting a grenade.");
            System.out.println("The computer has missed: " + ai.getTurnSkipped() + " turns due to hitting a grenade.");
            grid.revealGrid();
            this.onGoingGame = false;
        }
    }
    
}
