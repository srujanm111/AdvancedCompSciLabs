package Lab04_MelodyMaker;

import java.util.*;

public class QueueProbs {

    public Queue<Integer> evenFirst(Queue<Integer> nums) {
        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();

        while (!nums.isEmpty()) {
            int n = nums.poll();
            if (n % 2 == 0) evens.offer(n);
            else odds.offer(n);
        }

        while (!evens.isEmpty()) nums.offer(evens.poll());
        while (!odds.isEmpty()) nums.offer(odds.poll());

        return nums;
    }

    public Stack<Integer> primesUpToN(int n) {
        Stack<Integer> primes = new Stack<>();
        Queue<Integer> nums = new LinkedList<>();

        for (int i = 2; i <= n; i++) nums.offer(i);

        while (!nums.isEmpty()) {
            int prime = nums.poll();
            primes.push(prime);
            nums.removeIf(i -> i % prime == 0);
        }

        return primes;
    }

}
