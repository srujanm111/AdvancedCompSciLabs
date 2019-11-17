package Lab05_WordLadder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {

    private HashMap<Integer, ArrayList<String>> words;

    public Dictionary() {
        words = new HashMap<>();
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab05_WordLadder/dictionary.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNext()) {
            String word = input.next();
            if (!words.containsKey(word.length())) {
                words.put(word.length(), new ArrayList<>());
            }
            words.get(word.length()).add(word);
        }
    }

    public ArrayList<String> wordsOfLengthN(int n) {
        return words.get(n);
    }

    public String generateStep(String word) {
        ArrayList<String> otherWords = wordsOfLengthN(word.length());
        for (String otherWord : otherWords) {
            if (isOneStep(word, otherWord)) {
                otherWords.remove(otherWord);
                return otherWord;
            }
        }
        return null;
    }

    public boolean isOneStep(String word1, String word2) {
        int differences = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) differences++;
        }
        return differences == 1;
    }

    public ArrayList<String> possibleSteps(String word) {
        ArrayList<String> steps = new ArrayList<>();
        while (true) {
            String n = generateStep(word);
            if (n == null) break;
            steps.add(n);
        }
        return steps;
    }

    public void remove(String word) {
        wordsOfLengthN(word.length()).remove(word);
    }

}
