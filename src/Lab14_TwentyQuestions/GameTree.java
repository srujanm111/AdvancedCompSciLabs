package Lab14_TwentyQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */

public class GameTree {

    String gameFile;
    GameTreeNode root;
    GameTreeNode currentNode;

    /**
     * Constructor needed to create the game.
     *
     * @param fileName this is the name of the file we need to import the game questions
     *                 and answers from.
     */
    public GameTree(String fileName) {
        gameFile = fileName;
        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        root = createTree(input);
        currentNode = root;
    }

    private GameTreeNode createTree(Scanner input) {
        if (!input.hasNextLine()) return null;
        GameTreeNode node = new GameTreeNode(input.nextLine().trim());
        if (!node.data.endsWith("?")) return node;
        node.yes = createTree(input);
        node.no = createTree(input);
        return node;
    }

    /*
     * Add a new question and answer to the currentNode. If the current node has
     * the answer chicken, theGame.add("Does it swim?", "goose"); should change
     * that node like this:
     */
    // -----------Feathers?-----------------Feathers?------
    // -------------/----\------------------/-------\------
    // ------- chicken  horse-----Does it swim?-----horse--
    // -----------------------------/------\---------------
    // --------------------------goose--chicken-----------

    /**
     * @param newQ The question to add where the old answer was.
     * @param newA The new Yes answer for the new question.
     */
    public void add(String newQ, String newA) {
        String oldA = currentNode.data;
        currentNode.data = newQ;
        currentNode.yes = new GameTreeNode(newA);
        currentNode.no = new GameTreeNode(oldA);
    }

    /**
     * True if getCurrent() returns an answer rather than a question.
     *
     * @return False if the current node is an internal node rather than an answer
     * at a leaf.
     */
    public boolean foundAnswer() {
        if (currentNode.data.endsWith("?")) return false;
        return true;
    }

    /**
     * Return the data for the current node, which could be a question or an
     * answer.  Current will change based on the users progress through the game.
     *
     * @return The current question or answer.
     */
    public String getCurrent() {
        return currentNode.data;
    }

    /**
     * Ask the game to update the current node by going left for Choice.yes or
     * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
     *
     * @param yesOrNo
     */
    public void playerSelected(Choice yesOrNo) {
        if (yesOrNo == Choice.Yes) currentNode = currentNode.yes;
        else if (yesOrNo == Choice.No) currentNode = currentNode.no;
    }

    /**
     * Begin a game at the root of the tree. getCurrent should return the question
     * at the root of this GameTree.
     */
    public void reStart() {
        currentNode = root;
    }

    @Override
    public String toString() {
        ArrayList<String> lines = new ArrayList<>();
        nodeLine(lines, root, 0);
        StringBuffer toString = new StringBuffer();
        for (String line : lines) {
            toString.append(line + "\n");
        }
        return toString.toString();
    }

    private void nodeLine(ArrayList<String> lines, GameTreeNode node, int level) {
        if (node == null) return;
        nodeLine(lines, node.no, level + 1);
        lines.add(prependLiteral(level) + node.data);
        nodeLine(lines, node.yes, level + 1);
    }

    private String prependLiteral(int level) {
        char[] prepend = new char[level];
        for (int i = 0; i < prepend.length; i++) prepend[i] = '-';
        return new String(prepend);
    }

    /**
     * Overwrite the old file for this gameTree with the current state that may
     * have new questions added since the game started.
     */
    public void saveGame() {
        PrintWriter diskFile = null;
        try {
            diskFile = new PrintWriter(new File(gameFile));
        } catch (IOException io) {
            System.out.println("Could not create file: " + gameFile);
        }
        savePreOrder(diskFile, root);
        diskFile.close();
    }
    private void savePreOrder(PrintWriter diskFile, GameTreeNode node) {
        if (node == null) return;
        diskFile.println(node.data);
        savePreOrder(diskFile, node.yes);
        savePreOrder(diskFile, node.no);
    }

    private class GameTreeNode {
        String data;
        GameTreeNode yes;
        GameTreeNode no;

        public GameTreeNode(String data) {
            this.data = data;
        }
    }
}
