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
public class GameHandler {

    Scanner i = new Scanner(System.in);
    private String input;
    
    public GameHandler() {
    }
    
    public void promptUser() {
        input = i.next();
    }
    
}
