package Lab02_MyStack;

import java.util.*;

public class StackProbs {

    Stack<Integer> doubleUp(Stack<Integer> nums) {
        if (nums.empty()) return nums;
        int num = nums.pop();
        doubleUp(nums);
        nums.push(num);
        nums.push(num);
        return nums;
    }

    Stack<Integer> posAndNeg(Stack<Integer> nums) {
        Stack<Integer> negative = new Stack<>();
        Stack<Integer> positive = new Stack<>();

        while (!nums.empty()) {
            int num = nums.pop();
            if (num < 0) negative.push(num);
            else positive.push(num);
        }

        Stack<Integer> posNeg = new Stack<>();
        while (!negative.empty()) posNeg.push(negative.pop());
        while (!positive.empty()) posNeg.push(positive.pop());
        return posNeg;
    }

    Stack<Integer> shiftByN(Stack<Integer> nums, int n) {
        Stack<Integer> bottom = new Stack<>();
        Stack<Integer> shift = new Stack<>();

        int o = nums.size() - n;
        for (int i = 0; i < o; i++) bottom.push(nums.pop());
        while (!nums.empty()) shift.push(nums.pop());

        Stack<Integer> shifted = new Stack<>();
        while (!bottom.empty()) shifted.push(bottom.pop());
        while (!shift.empty()) shifted.push(shift.pop());

        return shifted;
    }

    String reverseVowels(String str) {
        Stack<Character> vowels = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels.push(c);
        }

        String reversed = "";
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') reversed += vowels.pop();
            else reversed += c;
        }

        return reversed;
    }

    boolean bracketBalance(String s) {
        Stack<Character> brackets = new Stack<>();

        for (Character b : s.toCharArray()) {
            if (b == '(' || b == '[') {
                brackets.push(b);
            } else {
                if (brackets.empty()) return false;
                if (b == ')') {
                    if (brackets.pop() != '(') return false;
                    continue;
                }
                if (!(b == ']' && brackets.pop() == '[')) return false;
            }
        }

        return brackets.empty();
    }

}
