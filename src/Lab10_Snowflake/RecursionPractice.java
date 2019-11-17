package Lab10_Snowflake;

import java.util.Arrays;
import java.util.Stack;

public class RecursionPractice {

    public static void main(String[] args) {
        printNums2(10);
    }

    static double sumReciprocals(int n) {
        if (n == 1) return 1;
        return 1.0/n + sumReciprocals(n-1);
    }

    static int productOfEvens(int n) {
        if (n == 1) return 2;
        return n*2 * productOfEvens(n-1);
    }

    static void doubleUp(Stack<Integer> nums) {
        if (nums.size() == 0) return;
        int num = nums.pop();
        doubleUp(nums);
        nums.push(num);
        nums.push(num);
    }

    static void countToBy(int n, int m) {
        if (n < 0) return;
        int num = n;
        countToBy(n-m, m);
        System.out.print(num + " ");
    }

    static int matchingDigits(int a, int b) {
        if (a == 0 && b == 0) return 0;
        if (a % 10 == b % 10) {
            if (a == 0 || b == 0) a = b = 0;
            return 1 + matchingDigits(a/10, b/10);
        }
        else return matchingDigits(a/10, b/10);
    }

    static void printThis(int n) {
        if (n == 1) {
            System.out.println("*");
            return;
        }
        String line = "";
        for (int i = 0; i < ((n - 1) / 2); i++) {
            line += "<";
        }
        line += (n % 2 == 0 ? "**" : "*");
        for (int i = 0; i < ((n - 1) / 2); i++) {
            line += ">";
        }
        printThis(n-1);
        System.out.println(line);
    }

    static void printNums2(int n) {
        if (n == 1) {
            System.out.println("1 ");
            return;
        }
        String line = "";
        for (int i = ((n + 1) / 2); i > 1 ; i--) {
            line += i + " ";
        }
        line += (n % 2 == 0 ? "1 1 " : "1 ");
        for (int i = 2; i <= ((n + 1) / 2); i++) {
            line += i + " ";
        }
        printNums2(n-1);
        System.out.println(line);
    }

}
