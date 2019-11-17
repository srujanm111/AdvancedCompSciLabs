package Lab23_Thievery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        Set<String> dict = new HashSet<>(Arrays.asList("hello", "how", "are", "you", "today"));
        System.out.println(w.wordBreakPrint("howareyou", dict));
        //how are you
        System.out.println(w.wordBreakPrint("todayhello", dict));
        //today hello
        System.out.println(w.wordBreakPrint("helloworld", dict));
        //null (no solution)
    }

    String wordBreakPrint(String sequence, Set<String> dict) {
        String breakRecursive = wordBreakRecursive(sequence, dict, 0);
        return breakRecursive.contains("$") ? "no solution" : breakRecursive;
    }

    String wordBreakRecursive(String sequence, Set<String> dict, int left) {
        if (left >= sequence.length()) {
            return "";
        }

        for (int i = 0; i < sequence.length(); i++) {

        }

        return "$";
    }

}
