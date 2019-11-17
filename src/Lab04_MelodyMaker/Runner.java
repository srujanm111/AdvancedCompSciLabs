package Lab04_MelodyMaker;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {

    public static void main(String[] args) {
        QueueProbs problems = new QueueProbs();
        System.out.println(problems.evenFirst(createQueue(3,5,4,17,6,83,1,84,16,37)));
        System.out.println(problems.primesUpToN(121));
    }

    public static Queue<Integer> createQueue(int... nums) {
        Queue<Integer> n = new LinkedList<>();
        for (int num : nums) {
            n.offer(num);
        }
        return n;
    }

}
