package Quizzes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Quiz {

    public static void main(String[] args) {
        System.out.println(allUnique("abcda"));
    }

    public static boolean allUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == s.length();
    }

}
