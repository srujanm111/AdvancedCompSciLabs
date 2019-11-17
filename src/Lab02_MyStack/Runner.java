package Lab02_MyStack;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        StackProbs problem = new StackProbs();

        System.out.println(problem.doubleUp(makeStack(1, 3, 5, 0, -1)));
        System.out.println(problem.posAndNeg(makeStack(2, 9, -4, 3, -1, 0, -6)));
        System.out.println(problem.shiftByN(makeStack(7, 23, -7, 0, 22, -8, 4, 5), 3));
        System.out.println(problem.reverseVowels("hello how are you"));
        System.out.println(problem.bracketBalance("(([()])))"));
        System.out.println(problem.bracketBalance("([()[]()])()"));
    }

    public static Stack<Integer> makeStack(int... nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) stack.push(num);
        return stack;
    }

}
