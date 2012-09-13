/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author arash
 */
public class Sokoban {

    private boolean isFinal(State s0) {
        for (Point box : s0.getBoxes()) {
            if(getMap()[box.y][box.x] != Map.SquareType.Target){
                return false;
            }
        }
        return true;
    }

    public static class Move {

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
        public int dy[] = {1, 0, -1, 0};
        public int dx[] = {0, 1, 0, -1};

        private Move reverse() {
            return new Move((dir+2)%4);
        }
    }
    public Map gameMap;

    private Map.SquareType[][] getMap() {
        return gameMap.map;
    }
    private State initState;

    public List<Move> solve() {
        State s = bfs();
        List<Move> moves = new ArrayList<Move>();
        while(s != initState){
            Move m = cameFrom.get(s);
            moves.add(m);
            s = applyMove(s, m.reverse());
        }
        
        return moves;
    }
    
    HashMap<State, Move> cameFrom;

    private State bfs() {
        // this is not memoized!
        cameFrom = new HashMap<State, Move>();
        Queue<State> q = new LinkedList<State>();
        q.add(initState);
        while (!q.isEmpty()) {
            State s0 = q.remove();
            if(isFinal(s0)){
                return s0;
            }
            for (Move m : Move.directions()) {
                State s = applyMove(s0, m);
                if (isLegit(s, m) && !cameFrom.containsKey(s)) {
                    cameFrom.put(s, m);
                    q.add(s);
                }
            }
        }
        return null;
    }

    private boolean isLegit(State s0, Move m) {
        State s = applyMove(s0, m);
        List<Point> all = Arrays.asList(s.getBoxes());
        all.add(s.getAgent());
        
        if(hasDuplicates(all)){
            return false;
        }
        for (Point p : all) {
            if (getMap()[p.y][p.x] == Map.SquareType.Wall) {
                return false;
            }
        }
        return true;
    }

    private State applyMove(State s, Move m) {
        Point agent = s.getAgent();
        Point nextLocation = m.movePoint(agent);
        Point[] newBoxes = new Point[s.getBoxes().length];
        for (int i = 0; i < newBoxes.length; i++) {
            Point point = s.getBoxes()[i];
            if(nextLocation == point){
                point = m.movePoint(point);
            }
            newBoxes[i] = point;
        }
        return new State(nextLocation, newBoxes);
    }

    static boolean hasDuplicates(final List<Point> points) {
        // Taken from <http://stackoverflow.com/a/3951563/621449>
        Set<Point> lump = new HashSet<Point>();
        for (Point i : points) {
            if (lump.contains(i)) {
                return true;
            }
            lump.add(i);
        }
        return false;
    }
    


}
