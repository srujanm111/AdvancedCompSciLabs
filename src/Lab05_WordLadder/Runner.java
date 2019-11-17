package Lab05_WordLadder;

import Lab03_MazeSolver.SquareStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            input = new Scanner(new File("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab05_WordLadder/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();

        while (input.hasNext()) {
            String word = input.next().toUpperCase();
            String endWord = input.next().toUpperCase();

            Queue<Stack<String>> wordStacks = new LinkedList<>();
            Dictionary dictionary = new Dictionary();

            if (!dictionary.wordsOfLengthN(word.length()).contains(word) || !dictionary.wordsOfLengthN(endWord.length()).contains(endWord)) {
                System.out.println("No Word Ladder Between " + word + " and " + endWord);
                continue;
            }

            for (String possibleStep : dictionary.possibleSteps(word)) {
                Stack<String> wordStack = new Stack<>();
                wordStack.push(possibleStep);
                wordStacks.offer(wordStack);
            }

            while (true) {
                if (wordStacks.isEmpty()) {
                    System.out.println("No Word Ladder Between " + word + " and " + endWord);
                    break;
                }
                Stack<String> wordStack = wordStacks.poll();
                if (wordStack.peek().equals(endWord)) {
                    System.out.print("Word Ladder For " + word + " and " + endWord + " is: ");
                    System.out.print(word + " ");
                    for (String s : wordStack) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
                }
                for (String possibleStep : dictionary.possibleSteps(wordStack.peek())) {
                    Stack<String> newWordStack = new Stack<>();
                    newWordStack.addAll(wordStack);
                    newWordStack.push(possibleStep);
                    wordStacks.offer(newWordStack);
                }
            }
        }

        System.out.println((System.currentTimeMillis() - start) / 1000 + "s");

    }

//    public static List<Stack<String>> buildLadder(String start, String end, int length) {
//        List<Stack<String>> allPossibleLadders = new ArrayList<>();
//
//        Queue<Stack<String>> wordStacks = new LinkedList<>();
//        Dictionary dictionary = new Dictionary();
//
//        if (!dictionary.wordsOfLengthN(start.length()).contains(start) || !dictionary.wordsOfLengthN(end.length()).contains(end)){
//            System.out.println("No Word Ladders Between " + start + " and " + end);
//            return null;
//        }
//
//        for (String possibleStep : dictionary.possibleSteps(start)) {
//            Stack<String> wordStack = new Stack<>();
//            wordStack.push(possibleStep);
//            wordStacks.offer(wordStack);
//        }
//
//        while (true) {
//            if (wordStacks.isEmpty()) {
//                return allPossibleLadders;
//            }
//            Stack<String> wordStack = wordStacks.poll();
//            if (wordStack.peek().equals(end)) {
//                if (wordStack.size() == length) {
//
//                }
//                allPossibleLadders.add(wordStack);
//                continue;
//            }
//            for (String possibleStep : dictionary.possibleSteps(wordStack.peek())) {
//                Stack<String> newWordStack = new Stack<>();
//                newWordStack.addAll(wordStack);
//                newWordStack.push(possibleStep);
//                wordStacks.offer(newWordStack);
//            }
//        }
//    }

}
