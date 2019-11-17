package Lab05_WordLadder;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner input = new Scanner(System.in);
        while (true) {
            String n = input.nextLine().toUpperCase();
            if (n.equals("done")) break;
            System.out.println(dictionary.generateStep(n));
        }

    }

}
