package Lab00_ShoppingCart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WelcomeBack {

    String getMiddle(String str) {
        return str.length() % 2 == 0 ? str.substring(str.length() / 2 - 1, str.length() / 2 + 1) : str.substring(str.length() / 2 - 1, str.length() / 2);
    }

    int[] sumNumbers(int n) {
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int o = 0; o <= i; o++) {
                sum += 0;
            }
            sums[i] = sum;
        }
        return sums;
    }

    int sumDigits(int num) {
        int sum = 0;
        while (num % 10 != 0) {
            sum += num % 10;
            sum /= 10;
        }
        return sum + num;
    }

    int keepSummingDigits(int num) {
        int sum = sumDigits(num);
        if (sum < 10) return sum;
        return keepSummingDigits(sum);
    }

    String getIntersection(int[] a, int[] b) {
        String intersection = "";
        for (int i = 0; i < a.length; i++) {
            for (int o = 0; o < b.length; o++) {
                if (a[i] == b[o]) {
                    intersection += a[i];
                    b[o] = -1;
                }
            }
        }
        return intersection;
    }

    Map<Integer, Integer> mapLengths(String[] words) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (String word : words) {
            counts.putIfAbsent(word.length(), 0);
            counts.put(word.length(), counts.get(word.length()) + 1);
        }

        return counts;
    }

    int sumDigitsRecur(int num) {
        if (num < 10) return num;
        return num % 10 + sumDigitsRecur(num / 10);
    }

    int sumWithoutCarry(int a, int b) {
        int sum = 0;
        while (a > 10 && b > 10) {
            int s = a % 10 + b % 10;
            if (s > 10) s = s % 10;
            sum = sum * 10 + s;
            a /= 10;
            b /= 10;
        }
        int s = a + b;
        if (s > 10) s = s % 10;
        sum = sum * 10 + s;
        return sum;
    }

    int buySell1(int[] stock) {
        int maxProfit = 0;
        for (int i = 0; i < stock.length; i++) {
            for (int o = i + 1; o < stock.length; o++) {
                if (stock[i] - stock[o] < maxProfit) maxProfit = stock[i] - stock[o];
            }
        }
        return maxProfit * -1;
    }

    void zeck(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));

        String fibString = "1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946";
        ArrayList<Integer> fib = new ArrayList<>();
        for (String n : fibString.split(", ")) fib.add(Integer.parseInt(n));

        while (input.hasNext()) {
            int num = input.nextInt();

            System.out.print(num + " = ");
            int sum = 0;
            while (sum != num) {
                int largest = 1;
                for (int n : fib) {
                    if (n>num-sum) break;
                    largest = n;
                }
                sum += largest;
                System.out.print(largest + " ");
            }
            System.out.println();
        }
    }

}
