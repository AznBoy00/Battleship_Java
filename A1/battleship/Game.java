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
    private int gameState = 0; //0=ongoing, 1=Player wins, 2=AI wins
    public final int GAME_SHIP_COUNT = 6;
    
    Grid grid= new Grid();
    
    public Game() {
        this.gameState = 0;
    }
    
    public void run() {
        System.out.println("Hi, let's play Battleship!\n");
        
        /*System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
        System.out.print("\nPosition of your rocket: ");
        input.nextLine();
        shootRocket(xy);*/
        grid.showGrid();
    }
    
    
    
    public void shootRocket(String xy) {
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
        grid.destroyMapObject(xy);
    }
    
    

}
