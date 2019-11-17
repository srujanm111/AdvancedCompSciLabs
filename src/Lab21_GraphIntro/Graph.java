package Lab21_GraphIntro;

import Lab15_PriorityQueues.Cookies;

import java.util.*;

public class Graph {

    private LinkedList<Integer>[] adjacencyList;

    public Graph(int size) {
        adjacencyList = new LinkedList[size];
    }

    public void addEdge(int vertex, int destination) {
        if (adjacencyList[vertex] == null) adjacencyList[vertex] = new LinkedList<>();
        adjacencyList[vertex].add(destination);
    }

    public void DFS(int start) {
        DFS(new boolean[adjacencyList.length], start);
        System.out.println();
    }

    private void DFS(boolean[] visited, int vertex) {
        if (visited[vertex]) return;
        visited[vertex] = true;
        System.out.print(vertex + " ");
        PriorityQueue<Integer> inOrder = new PriorityQueue<>(adjacencyList[vertex]);
        while (inOrder.peek() != null) {
            DFS(visited, inOrder.poll());
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[adjacencyList.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (visited[next]) continue;
            visited[next] = true;
            System.out.print(next + " ");
            PriorityQueue<Integer> inOrder = new PriorityQueue<>(adjacencyList[next]);
            while (inOrder.peek() != null) {
                queue.offer(inOrder.poll());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 2);
        graph.addEdge(6, 3);
        graph.addEdge(6, 7);
        graph.addEdge(3, 5);
        graph.addEdge(7, 0);
        graph.addEdge(7, 1);

        graph.DFS(3); //D C E G H A B F

        graph.BFS(3); //D C E F G H A B
    }
}

//A - 0
//B - 1
//C - 2
//D - 3
//E - 4
//F - 5
//G - 6
//H - 7
