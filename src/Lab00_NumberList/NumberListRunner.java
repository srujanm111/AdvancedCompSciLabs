package Lab00_NumberList;

import java.util.ArrayList;

public class NumberListRunner {
    public static void main(String[] args) {
//        /*
//         * NumberList objects should function in the same way as an ArrayList that stores Integers
//         *
//         * in other words, NumberList list = new NumberList(); should work the
//         * same as ArrayList<Integrer> list = new ArrayList<>();
//         */
//
//        //test constructor
//        NumberList<Integer> list = new NumberList<>();
//
//        //test isEmpty()
//        System.out.println(list.isEmpty());
//
//        //test cases that will go out of bounds
//        try {
//            list.add(-1, 5); //add element 5 at index -1
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Your out of bounds exception works");
//        }
//
//        //test the add() method and toString() method
//        list.add(2);
//        list.add(4);
//        list.add(6);
//        list.add(8);
//        System.out.println(list);
//
//        //test the get() method
//        System.out.println(list.get(0));
//        System.out.println(list.get(list.size() - 1));
//
//        //test the set() method
//        list.set(0, 20);
//        list.set(2, 40);
//        System.out.println(list);
//
//        //test the remove() method
//        list.remove(list.size() - 2);
//        System.out.println(list);
//
//        //test misc.
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//
//        //test two parameter add() method, list should begin empty
//        list.add(0, 23);
//        list.add(1, 17);
//        list.add(2, 44);
//        System.out.println(list);
//
//        list.add(0, 72);
//        list.add(2, 65);
//        System.out.println(list);
        System.out.println(largestPrimeRunNumber(1000));
    }

    private static ArrayList<Integer> primesUpToN(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        for (int i = 3; i <= n; i+=2) {
            nums.add(i);
        }
        for (int i = 1; i < nums.size(); i++) {
            int check = nums.get(i);
            for (int i1 = i+1; i1 < nums.size(); i1++) {
                if (nums.get(i1) % check == 0) {
                    nums.remove(i1);
                    i1--;
                }
            }
        }
        System.out.println(nums);
        return nums;
    }

    private static int largestPrimeRunNumber(int n) {
        ArrayList<Integer> primes = primesUpToN(n);
        int largest = primes.get(0);
        int k = largest;
        for (int i = 1; i < primes.size() && k <= n; i++) {
            if (primes.contains(k)) largest = k;
            k += primes.get(i);
        }
        return largest;
    }
}