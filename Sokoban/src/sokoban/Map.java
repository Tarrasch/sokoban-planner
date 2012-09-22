package sokoban;

import java.awt.Point;

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
    
    public SquareType[][] map; // [y][x]

    public Map(SquareType[][] map) {
        this.map = map;
        deadEnd = new boolean[map.length][map[0].length];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                SquareType squareType = map[y][x];
                if(squareType == SquareType.Empty){
                    for (int dir = 0; dir < 3; dir++) {
                        int x1 = x + Move.dx[dir];
                        int y1 = y + Move.dy[dir];
                        int x2 = x + Move.dx[dir+1];
                        int y2 = y + Move.dy[dir+1];
                        if(map[y1][x1] == SquareType.Wall && map[y2][x2] == SquareType.Wall){
                            deadEnd[y][x] = true;
                        }
                    }
                }
            }
        }
    }
    
    private boolean deadEnd[][];
    
    public boolean deadEndForBoxes(Point p){
        return deadEnd[p.y][p.x];
    }
}
