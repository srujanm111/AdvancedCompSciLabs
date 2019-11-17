package Lab21_GraphIntro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Scooby {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab21_GraphIntro/Scooby.dat"));
        } catch (FileNotFoundException e ) {}

        int cases = input.nextInt();
        input.nextLine();
        for (int cs = 0; cs < cases; cs++) {
            HashMap<Character, LinkedList<Character>> adjacencyList = new HashMap<>();

            String[] edges = input.nextLine().split(" ");

            for (String edge : edges) {
                if (!adjacencyList.containsKey(edge.charAt(0)))
                    adjacencyList.put(edge.charAt(0), new LinkedList<>());
                adjacencyList.get(edge.charAt(0)).add(edge.charAt(1));
                if (!adjacencyList.containsKey(edge.charAt(1)))
                    adjacencyList.put(edge.charAt(1), new LinkedList<>());
                adjacencyList.get(edge.charAt(1)).add(edge.charAt(0));
            }

            String check = input.nextLine();

            System.out.println(search(adjacencyList, new HashSet<>(), check.charAt(0), check.charAt(1)) ? "yes" : "no");
        }
    }

    private static boolean search(HashMap<Character, LinkedList<Character>> graph, HashSet<Character> visited, char vertex, char destination) {
        if (vertex == destination) return true;
        if (visited.contains(vertex)) return false;
        visited.add(vertex);

        boolean found = false;
        if (graph.get(vertex) == null) return false;
        for (Character character : graph.get(vertex)) {
            if (search(graph, visited, character, destination)) {
                found = true;
                break;
            }
        }

        return found;
    }

}
