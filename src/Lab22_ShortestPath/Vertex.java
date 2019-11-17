package Lab22_ShortestPath;

import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    int ID;
    int x, y;
    double distance;
    Vertex pred;
    List<Integer> adjacent;
    boolean visited;

    public Vertex(int ID, int x, int y) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.distance = Double.POSITIVE_INFINITY;
        this.pred = null;
        this.adjacent = new LinkedList<>();
        visited = false;
    }

    public void addEdge(int destination) {
        adjacent.add(destination);
    }

    public double findDistance(Vertex dest) {
        return Math.sqrt(Math.pow(dest.x - x, 2) + Math.pow(dest.y - y, 2));
    }

    @Override
    public int compareTo(Vertex o) {
        return (int)(distance - o.distance);
    }

    @Override
    public String toString() {
        return ID + "";
    }
}
