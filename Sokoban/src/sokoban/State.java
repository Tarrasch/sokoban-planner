package sokoban;


import java.awt.Point;
import java.util.Set;

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

    public Set<Point> getBoxes() {
        return boxes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.agent != null ? this.agent.hashCode() : 0);
        hash = 71 * hash + (this.boxes != null ? this.boxes.hashCode() : 0);
        return hash;
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
        if (this.boxes != other.boxes && (this.boxes == null || !this.boxes.equals(other.boxes))) {
            return false;
        }
        return true;
    }

    private Point agent;
    private Set<Point> boxes;

    public State(Point agent, Set<Point> boxes) {
        this.agent = agent;
        this.boxes = boxes;
    }

}
