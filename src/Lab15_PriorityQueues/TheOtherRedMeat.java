package Lab15_PriorityQueues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TheOtherRedMeat {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab15_PriorityQueues/goat.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int numGoats = input.nextInt();
            Queue<Goat> goats = new PriorityQueue<>();
            for (int i1 = 0; i1 < numGoats; i1++) {
                int cycleLength = input.nextInt();
                int[] l = new int[cycleLength];
                for (int i2 = 0; i2 < cycleLength; i2++) {
                    l[i2] = input.nextInt();
                }
                goats.offer(new Goat(l));
            }

            int days = 0;
            while (true) {
                Goat leastMilk = goats.remove();
                if (leastMilk.getCurrent() == goats.peek().getCurrent()) {
                    goats.offer(leastMilk);
                    boolean flag = true;
                    CHECK: for (Goat goat : goats) {
                        for (int i1 : goat.cycle) {
                            if (i1 < leastMilk.getCurrent()) {
                                flag = false;
                                break CHECK;
                            }
                        }
                    }
                    if (flag) break;
                }
                for (Goat goat : goats) {
                    goat.nextDay();
                }
                days++;
            }
            System.out.println(goats.size() + " " + days);
        }
    }

    private static class Goat implements Comparable<Goat> {
        int[] cycle;
        private int current;

        public Goat(int[] cycle) {
            this.cycle = cycle;
            current = 0;
        }

        public int getCurrent() {
            return cycle[current];
        }

        public void nextDay() {
            current++;
            if (current >= cycle.length) current = 0;
        }

        @Override
        public int compareTo(Goat o) {
            return this.getCurrent() - o.getCurrent();
        }
    }

}
