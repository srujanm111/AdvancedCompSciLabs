package Lab11_ForestFire;

import java.util.*;

public class BacktrackingPractice {

    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();
        nums.add(1);nums.add(2);nums.add(3);nums.add(4);
        //Set<int[]> arrangements = generateAllArrangements(nums);
//        for (int[] arrangement : arrangements) {
//            System.out.println(Arrays.toString(arrangement));
//        }
    }

    static void printBinary(int digits) {
        printBinaryHelper(digits, "");
    }

    private static void printBinaryHelper(int digits, String binary) {
        if (binary.length() == digits) {
            System.out.print(binary + " ");
            return;
        }
        printBinaryHelper(digits, binary + "0");
        printBinaryHelper(digits, binary + "1");
    }

    static void climbStairs(int steps) {
        climbStairsHelper(steps, "", 0);
    }

    private static void climbStairsHelper(int steps, String stepSequence, int stepVal) {
        if (stepVal == steps) {
            System.out.println(stepSequence.substring(0, stepSequence.length()-2));
            return;
        } else if (stepVal > steps) {
            return;
        }
        climbStairsHelper(steps, stepSequence + "1, ", stepVal + 1);
        climbStairsHelper(steps, stepSequence + "2, ", stepVal + 2);
    }

    static void campsite(int x, int y) {
        campsiteHelper(x, y, 0, 0, "");
    }

    private static void campsiteHelper(int xDest, int yDest, int x, int y, String directions) {
        if (x == xDest && y == yDest) {
            System.out.println(directions);
            return;
        } else if (x > xDest || y > yDest) {
            return;
        }
        campsiteHelper(xDest, yDest, x + 1, y, directions + "E ");
        campsiteHelper(xDest, yDest, x, y + 1, directions + "N ");
        campsiteHelper(xDest, yDest, x + 1, y + 1, directions + "NE ");
    }

    static int getMax(List<Integer> nums, int limit) {
        return getMaxHelper(nums, limit, 0, 0);
    }

    private static int getMaxHelper(List<Integer> nums, int limit, int i, int sum) {
        if (sum > limit) return Integer.MIN_VALUE;
        if (i >= nums.size()) return sum;

        int includeNext = getMaxHelper(nums, limit, i + 1, sum + nums.get(i));
        int skipNext = getMaxHelper(nums, limit, i + 1, sum);

        return Math.max(includeNext, skipNext);
    }

    static int makeChange(int amount) {
        return makeChangeHelper(new ArrayList<>(Arrays.asList(1, 5, 10, 25)), amount, 0, 0);
    }

    static void makeChange2(int amount) {
        System.out.println(" P  N  D  Q ");
        System.out.println("------------");
        makeChangeHelper2(new ArrayList<>(Arrays.asList(1, 5, 10, 25)), amount, 0, 0, 0, 0, 0, 0);
    }

    private static int makeChangeHelper(List<Integer> coins, int amount, int sum, int i) {
        if (sum > amount) return 0;
        if (i >= coins.size()) return sum == amount ? 1 : 0;

        int skip = makeChangeHelper(coins, amount, sum, i + 1);
        int repeat = makeChangeHelper(coins, amount, sum + coins.get(i), i);

        return skip + repeat;
    }

    private static void makeChangeHelper2(List<Integer> coins, int amount, int sum, int i, int pennies, int nickels, int dimes, int quarters) {
        if (sum > amount) return;
        if (i >= coins.size()) {
            if (sum == amount) {
                System.out.println("[" + pennies + ", " + nickels + ", " + dimes + ", " + quarters + "]");
            }
            return;
        }

        makeChangeHelper2(coins, amount, sum, i + 1, pennies, nickels, dimes, quarters);
        switch (coins.get(i)) {
            case 1: ++pennies; break;
            case 5: ++nickels; break;
            case 10: ++dimes; break;
            case 25: ++quarters; break;
        }
        makeChangeHelper2(coins, amount, sum + coins.get(i), i, pennies, nickels, dimes, quarters);
    }

    static String longestCommonSub(String a, String b) {
        String a1 = "";
        for (char c : a.toCharArray()) {
            if (b.contains(c + "")) a1 += c;
        }
        String b1 = "";
        for (char c : b.toCharArray()) {
            if (a.contains(c + "")) b1 += c;
        }
        return longestCommonSubHelper(a1, b1, 0, 0, "", "");
    }

    private static String longestCommonSubHelper(String a, String b, int i, int o, String aSequence, String bSequence) {
        if (i >= a.length() || o >= b.length()) {
            if (aSequence.equals(bSequence)) return aSequence;
            return "";
        }
        if (aSequence.length() >= a.length() || bSequence.length() >= b.length()) {
            if (aSequence.equals(bSequence)) return aSequence;
            return "";
        }

        String one = longestCommonSubHelper(a, b, i + 1, o + 1, aSequence + a.charAt(i), bSequence + b.charAt(o));
        String two = longestCommonSubHelper(a, b, i, o + 1, aSequence, bSequence);
        String three = longestCommonSubHelper(a, b, i + 1, o, aSequence, bSequence);

        return longest(one, two, three);
    }

    private static String longest(String... sequences) {
        String longest = "";
        for (String sequence : sequences) {
            if (sequence.length() > longest.length()) longest = sequence;
        }
        return longest;
    }

    //ADVANCED 1
    static Set<MyArray> generateAllArrangements(Set<Integer> set) {
        MyArray nums = new MyArray(new int[set.size()]);
        int i = 0;
        for (Integer integer : set) nums.array[i++] = integer;
        Set<MyArray> arrangements = new HashSet<>();
        generateAllArrangementsHelper(arrangements, nums, 0, nums.array.length-1);
        return arrangements;
    }

    private static void generateAllArrangementsHelper(Set<MyArray> arrangements, MyArray sequence, int left, int right) {
        if (right < 0 || left >= sequence.array.length) {
            arrangements.add(sequence);
            return;
        }

        generateAllArrangementsHelper(arrangements, swap(sequence, left, right), left + 1, right - 1);
        generateAllArrangementsHelper(arrangements, sequence, left, right - 1);
        generateAllArrangementsHelper(arrangements, sequence, left + 1, right);
    }

    private static class MyArray {
        int[] array;

        public MyArray(int[] array) {
            this.array = array;
        }

        @Override
        public int hashCode() {
            int hashCode = 0;
            int multiplier = 7;
            for (int i : array) {
                hashCode += multiplier * i;
                multiplier *= 2;
            }
            return hashCode;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //finish this
            return new Object();
        }
    }

    private static MyArray swap(MyArray sequence, int left, int right) {
        int temp = sequence.array[right];
        sequence.array[right] = sequence.array[left];
        sequence.array[left] = temp;
        return sequence;
    }

}
