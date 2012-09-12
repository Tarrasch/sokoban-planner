package sokoban;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arash
 */
public class Map {
    public enum SquareType {
        Empty, Wall, Target;
    }
    
    public SquareType[][] map;

    public Map(SquareType[][] map) {
        this.map = map;
    }
    
}
