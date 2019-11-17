package Lab15_PriorityQueues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MagicalCandyBag {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab15_PriorityQueues/monk.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int nBags = input.nextInt();
            int minutes = input.nextInt();
            Queue<Integer> bags = new PriorityQueue<>(Collections.reverseOrder());
            for (int i1 = 0; i1 < nBags; i1++) {
                bags.offer(input.nextInt());
            }

            int maxCandies = 0;
            for (int i1 = 0; i1 < minutes; i1++) {
                int big = bags.remove();
                maxCandies += big;
                bags.offer(big/2);
            }
            System.out.println(maxCandies);
        }
    }

}
