package Lab22_ShortestPath;

import java.util.Scanner;

public class Graph {

    int V;
    int E;

    Vertex[] vertices;

    public Graph(Scanner input) {
        V = input.nextInt();
        E = input.nextInt();

        vertices = new Vertex[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = new Vertex(input.nextInt(), input.nextInt(), input.nextInt());
        }

        for (int i = 0; i < E; i++) {
            vertices[input.nextInt()].addEdge(input.nextInt());
        }
    }

    public double distance(int from, int to) {
        return vertices[from].findDistance(vertices[to]);
    }
}
