package Lab23_Thievery;

import Utilities.StopWatch;

import java.util.HashMap;

public class Fibonacci {

    public HashMap<Integer, Long> memo;

    public Fibonacci() {
        this.memo = new HashMap<>();
    }

    public long fibonacci(int n) {
        if (n < 0)
            throw new IllegalArgumentException("no negatives");
        if (n == 0 || n == 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public long fibonacciMemo(int n) {
        if (n < 0)
            throw new IllegalArgumentException("no negatives");
        if (n == 0 || n == 1)
            return n;

        if (!memo.containsKey(n)) {
            memo.put(n, fibonacciMemo(n-1) + fibonacciMemo(n-2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(fibonacci.fibonacci(40));
        stopWatch.stop();
        System.out.println("took: " + stopWatch.getTimeElapsed());
        stopWatch.reset();
        stopWatch.start();
        System.out.println(fibonacci.fibonacciMemo(40));
        stopWatch.stop();;
        System.out.println("took: " + stopWatch.getTimeElapsed());

    }

}
