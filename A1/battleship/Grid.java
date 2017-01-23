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
public class Grid {
    
    private MapObject[][] mapObject;
    private boolean isDestroyed = false;
    
    public Grid(){
        this.mapObject = new MapObject[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.mapObject[i][j] = new MapObject(0, 0);
            }
        }
    }
    
    public void insertGrid(String xy, int type, int player) {
        int x = convertLetter(xy);
        int y = Integer.parseInt(xy.substring(1, 2)) - 1;
        this.mapObject[y][x].setType(type);
        this.mapObject[y][x].setOwner(player);
    }
    
    public int getGridType(String xy) {
        int x = convertLetter(xy);
        int y = Integer.parseInt(xy.substring(1, 2)) - 1;
        return this.mapObject[y][x].getType();
    }
    
    public void showGrid() {
        for (int i = 0; i < 8; i++) {
            System.out.print("\t");
            for (int j = 0; j < 8; j++) {
                switch(this.mapObject[i][j].getType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        System.out.print("_ ");
                        break;
                    case 5:
                        System.out.print("* ");
                        break;
                    case 6:
                        System.out.print("S ");
                        break;
                    case 7:
                        System.out.print("g ");
                        break;
                    case 8:
                        System.out.print("S ");
                        break;
                    case 9:
                        System.out.print("G ");
                        break;
                    default:
                        System.out.print("E ");//E for error
                        break;
                }
            }
            System.out.println();
        }
    }
    
    public void revealGrid() {
        for (int i = 0; i < 8; i++) {
            System.out.print("\t");
            for (int j = 0; j < 8; j++) {
                switch(this.mapObject[i][j].getType()) {
                    case 0:
                        System.out.print("_ ");
                        break;
                    case 1:
                        System.out.print("s ");
                        break;
                    case 2:
                        System.out.print("g ");
                        break;
                    case 3:
                        System.out.print("S ");
                        break;
                    case 4:
                        System.out.print("G ");
                        break;
                    case 5:
                        System.out.print("* ");
                        break;
                    case 6:
                        System.out.print("S ");
                        break;
                    case 7:
                        System.out.print("g ");
                        break;
                    case 8:
                        System.out.print("S ");
                        break;
                    case 9:
                        System.out.print("G ");
                        break;
                    default:
                        System.out.print("E ");//E for error
                        break;
                }
            }
            System.out.println();
        }
    }
    
    private int convertLetter(String xy) {
        xy = xy.toUpperCase();
        char x = xy.charAt(0);
        switch (x) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            default:
                return -1;
        }
    }
    
    public void destroyMapObject(String xy) {
        int x = convertLetter(xy);
        int y = Integer.parseInt(xy.substring(1, 2)) - 1;
        switch (this.mapObject[y][x].getType()) {
            case 0:
                this.mapObject[y][x].setType(5);
                break;
            case 1:
                this.mapObject[y][x].setType(6);
                break;
            case 2:
                this.mapObject[y][x].setType(7);
                break;
            case 3:
                this.mapObject[y][x].setType(8);
                break;
            case 4:
                this.mapObject[y][x].setType(9);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                break;
        }
    }
}
