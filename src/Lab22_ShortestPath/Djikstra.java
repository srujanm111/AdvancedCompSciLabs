package Lab22_ShortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Djikstra {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab22_ShortestPath/input6.txt"));
        } catch (FileNotFoundException e ) {}

        Graph graph = new Graph(input);

        int start = input.nextInt();
        int desination = input.nextInt();

        graph.vertices[start].distance = 0;
        PriorityQueue<Vertex> next = new PriorityQueue<>();
        for (Vertex vertex : graph.vertices) {
            next.offer(vertex);
        }

        while (!next.isEmpty()) {
            Vertex v = next.poll();
            for (Integer integer : v.adjacent) {
                if (!graph.vertices[integer].visited)
                    relax(v, graph.vertices[integer]);
            }
        }

        System.out.println(graph.vertices[desination].distance);
        printShortestPath(graph.vertices[desination]);
    }

    public static void printShortestPath(Vertex vertex) {
        if (vertex == null) return;
        printShortestPath(vertex.pred);
        System.out.print(vertex + " ");
    }

    public static void relax(Vertex v, Vertex w) {
        double distance = v.distance + v.findDistance(w);
        if (distance < w.distance) {
            w.distance = distance;
            w.pred = v;
        }
    }

}
