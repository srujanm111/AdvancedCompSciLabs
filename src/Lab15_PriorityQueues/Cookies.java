package Lab15_PriorityQueues;

import java.io.*;
import java.util.*;

public class Cookies {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab15_PriorityQueues/cookies.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int c = input.nextInt();
        int minSweetness = input.nextInt();

        Queue<Integer> cookies = new PriorityQueue<>();
        while (input.hasNextInt()) cookies.offer(input.nextInt());

        int operations = 0;
        while (true) {
            if (cookies.size() <= 1) {
                System.out.println(-1);
                break;
            }
            boolean flag = true;
            for (Integer cookie : cookies) {
                if (cookie < minSweetness) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(operations);
                break;
            }
            int newSweet = cookies.poll() + cookies.remove()*2;
            cookies.offer(newSweet);
            operations++;
        }
    }

}
