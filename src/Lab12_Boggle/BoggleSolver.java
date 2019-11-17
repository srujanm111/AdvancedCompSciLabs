package Lab12_Boggle;

import Lab12_Boggle.BoggleBoard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BoggleSolver {

    public Dictionary dictionary;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
    public BoggleSolver(String dictionaryName) {
        dictionary = new Dictionary(dictionaryName);
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable object
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        long start = System.currentTimeMillis();
        Set<String> words = new HashSet<>();
        for (int i = 0; i < board.rows(); i++) {
            for (int i1 = 0; i1 < board.cols(); i1++) {
                getAllValidWords(words, board, "", i1, i, new boolean[board.rows()][board.cols()]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start));
        return words;
    }

    private void getAllValidWords(Set<String> words, BoggleBoard board, String word, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= board.cols() || y >= board.rows()) return;
        if (visited[y][x]) return;
        if (!dictionary.isValidPrefix(word)) return;
        word += board.getLetter(y, x) == 'Q' ? "QU" : board.getLetter(y, x);
        if (dictionary.isValidWord(word)) words.add(word);
        visited[y][x] = true;

        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                getAllValidWords(words, board, word, x + j, y + i, visited);

        visited[y][x] = false;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A - Z.)
    public int scoreOf(String word) {
        if (!dictionary.isValidWord(word)) return 0;

        if (word.length() <= 2) return 0;
        if (word.length() <= 4) return 1;
        if (word.length() == 5) return 2;
        if (word.length() == 6) return 3;
        if (word.length() == 7) return 5;
        return 11;
    }

    public static void main(String[] args) {
        System.out.println("WORKING");

        BoggleBoard board = new BoggleBoard("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab12_Boggle/data/board-q.txt");
        BoggleSolver solver = new BoggleSolver("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab12_Boggle/data/dictionary-algs4.txt");

        int totalPoints = 0;

        for (String s : solver.getAllValidWords(board)) {
            System.out.println(s + ", points = " + solver.scoreOf(s));
            totalPoints += solver.scoreOf(s);
        }

        System.out.println("Score = " + totalPoints); //should print 84

        new BoggleGame(4, 4);
    }

}
