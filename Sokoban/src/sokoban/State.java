package sokoban;


import java.awt.Point;
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arash
 */
public class State {

    public Point getAgent() {
        return agent;
    }

    public Point[] getBoxes() {
        return boxes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (this.agent != other.agent && (this.agent == null || !this.agent.equals(other.agent))) {
            return false;
        }
        if (!Arrays.deepEquals(this.boxes, other.boxes)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.agent != null ? this.agent.hashCode() : 0);
        hash = 79 * hash + Arrays.deepHashCode(this.boxes);
        return hash;
    }
    
    private Point agent;
    // TODO: Whoups, would have been better with Set instead of array!
    private Point[] boxes;

    public State(Point agent, Point[] boxes) {
        this.agent = agent;
        this.boxes = boxes;
    }
}
