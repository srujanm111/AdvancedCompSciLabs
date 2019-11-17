package Lab15_PriorityQueues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Kenny {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab15_PriorityQueues/kenny.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Queue<Query> queries = new PriorityQueue<>();

        while (true) {
            String[] line = input.nextLine().split(" ");
            if (line[0].equals("#")) break;
            queries.offer(new Query(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
        }

        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            Query next = queries.remove();
            System.out.println(next);
            next.timeElapsed += next.period;
            queries.offer(next);
        }
    }

    private static class Query implements Comparable<Query> {
        int Q_num;
        int period;
        int timeElapsed;

        public Query(int q_num, int period) {
            Q_num = q_num;
            this.period = period;
            timeElapsed = period;
        }

        @Override
        public int compareTo(Query o) {
            int timeDif = this.timeElapsed - o.timeElapsed;
            if (timeDif == 0) {
                if (this.Q_num < o.Q_num) return -1;
                return 1;
            }
            return timeDif;
        }

        @Override
        public String toString() {
            return Q_num + "";
        }

    }

}
