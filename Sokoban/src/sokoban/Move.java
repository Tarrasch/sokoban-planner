/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Point;

/**
 *
 * @author arash
 */
public class Move {

    public int dir;

    public Move(int dir) {
        this.dir = dir;
    }

    static public Move[] directions() {
        Move[] dirs = {new Move(0), new Move(1), new Move(2), new Move(3)};
        return dirs;
    }

    public Point movePoint(Point p) {
        return new Point(p.x + dx[dir], p.y + dy[dir]);
    }
    public static int dy[] = {1, 0, -1, 0};
    public static int dx[] = {0, 1, 0, -1};

    private Move reverse() {
        return new Move((dir + 2) % 4);
    }

    @Override
    public String toString() {
        String[] sa = {"up", "right", "down", "left"};
        return "Move " + sa[dir];
    }
}
