package Lab15_PriorityQueues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MathCostsBucks {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab15_PriorityQueues/mathCosts.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            int n = input.nextInt();
            if (n == 0) break;

            Queue<Integer> nums = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                nums.offer(input.nextInt());
            }

            int cost = 0;
            while (nums.size() > 1) {
                int sum = 0;
                cost += sum = nums.remove() + nums.remove();
                nums.offer(sum);
            }
            System.out.println(cost);
        }
    }

}
