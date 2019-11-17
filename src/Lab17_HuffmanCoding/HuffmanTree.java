package Lab17_HuffmanCoding;

import java.io.*;
import java.util.*;

public class HuffmanTree {

    private Node head;

    private HuffmanTree(int[] count) {
        PriorityQueue<Node> trees = new PriorityQueue<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            trees.offer(new Node(count[i], i));
        }
        trees.offer(new Node(1, 256));
        while (trees.size() > 1) {
            Node left = trees.poll();
            Node right = trees.poll();
            Node newNode = new Node(left.count + right.count, -1);
            newNode.left = left;
            newNode.right = right;
            trees.offer(newNode);
        }
        head = trees.remove();
    }

    private HuffmanTree(String codeFile) {
        Scanner input = null;
        try {
            input = new Scanner(new File(codeFile));
        } catch (FileNotFoundException e) {
        }

        head = new Node(0, -1);
        while (input.hasNextLine()) {
            int n = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            Node node = head;
            for (char c : code.toCharArray()) {
                if (c == '0') {
                    if (node.left == null)
                        node.left = new Node(0, -1);
                    node = node.left;
                } else {
                    if (node.right == null)
                        node.right = new Node(0, -1);
                    node = node.right;
                }
            }
            node.c = n;
        }
    }

    private void decode(BitInputStream in, String outFile) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(outFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MAIN: while (true) {
            int first = in.readBit();
            Node node = first == 0 ? head.left : head.right;
            while (true) {
                if (node.left == null && node.right == null) {
                    if (node.c == 256) break MAIN;
                    writer.print((char)node.c);
                    break;
                }
                node = in.readBit() == 0 ? node.left : node.right;
            }
        }
        in.close();
        writer.close();
    }

    private void write(String fileName) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        write(writer, head, "");
        writer.close();
    }

    private void write(PrintWriter writer, Node node, String binary) {
        if (node.right == null && node.left == null) {
            writer.println(node.c);
            writer.println(binary);
        } else {
            write(writer, node.left, binary + "0");
            write(writer, node.right, binary + "1");
        }
    }

    private void encode(String inputFile, String codeFile) {
        HashMap<Integer, String> charToBinary = new HashMap<>();
        Scanner input = null;
        try {
            input = new Scanner(new File(codeFile));
        } catch (FileNotFoundException e) {
        }

        while (input.hasNextLine()) {
            int n = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            charToBinary.put(n, code);
        }

        BitOutputStream out = new BitOutputStream("/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab17_HuffmanCoding/GeneratedFiles/" + inputFile.substring(inputFile.lastIndexOf("/") + 1, inputFile.lastIndexOf('.')) + ".short");

        try {
            input = new Scanner(new File(inputFile));
        } catch (FileNotFoundException e) {
        }
        input.useDelimiter("");
        while (input.hasNext()) {
            for (char c : charToBinary.get((int) input.next().charAt(0)).toCharArray()) {
                out.writeBit(Character.getNumericValue(c));
            }
        }
        for (char c : charToBinary.get(256).toCharArray()) {
            out.writeBit(Character.getNumericValue(c));
        }
        out.close();
    }

    public static void compress(String fileName) {
        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
        }
        input.useDelimiter("");
        int[] counts = new int[256];
        while (input.hasNext())
            counts[input.next().charAt(0)] += 1;

        String codeFile = "/Users/srujan_mupparapu/IdeaProjects/AdvancedCompSciLabs/src/Lab17_HuffmanCoding/GeneratedFiles/" + fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf('.')) + ".code";
        HuffmanTree tree = new HuffmanTree(counts);
        tree.write(codeFile);
        tree.encode(fileName, codeFile);
    }

    public static void expand(String codeFile, String compressedFile, String newFileName) {
        HuffmanTree tree = new HuffmanTree(codeFile);
        tree.decode(new BitInputStream(compressedFile), newFileName);
    }

}

class Node implements Comparable<Node> {

    int count;
    int c;
    Node left, right;

    public Node(int count, int c) {
        this.count = count;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return count - o.count;
    }

    @Override
    public String toString() {
        if (c == -1) return count + "";
        return (char) c + "";
    }
}
