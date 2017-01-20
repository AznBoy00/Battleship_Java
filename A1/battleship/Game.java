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

    Scanner i = new Scanner(System.in);
    private String input;
    private int gameState = 0; //0=ongoing, 1=Player wins, 2=AI wins
    private int playerTurn;
    private int aiTurn;
    
    Grid grid= new Grid();
    
    public void run() {
        grid.createGrid();
        grid.showGrid();
    }

    public void promptUser() {
        input = i.next();
    }
    
    public void checkWinner() { //0=ongoing, 1=Player wins, 2=AI wins
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
    
    public void skipTurn(int player) {
        
    }
    
}
