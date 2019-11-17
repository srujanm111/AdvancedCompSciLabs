package Quizzes;

import java.util.*;

public class LeastPositiveMultiple {
    public static final int ID = 226216;

    /**
     * Given an integer n, return the least positive multiple of n, made up of only 0's and 9'
     *
     * @param n the value being solved for
     * @return the solution (the least postive int that is a multiple of @param n)
     */
    public static int leastMultiple(int n) {
        return lm(n);
    }

    private static int lm(int n) {
        Queue<String> ints = new LinkedList<>();
        ints.offer("9");
        while (!ints.isEmpty()) {
            ints.offer(ints.peek() + "0");
            ints.offer(ints.peek() + "9");
            try {
                int num = Integer.parseInt(ints.poll());
                if (num % n == 0) {
                    return num;
                }
            } catch (NumberFormatException e) {

            }
        }

        return -1; //replace
    }

}