package Lab12_Boggle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {

    public static final int PREFIX_LENGTH = 7; //increasing prefix length reduces run time up to a certain point

    private Set<String> words;
    private PrefixTrie prefixes;

    public Dictionary(String dictionaryName) {
        words = new HashSet<>();
        prefixes = new PrefixTrie();
        File dictionaryFile = new File(dictionaryName);
        Scanner input = null;
        try {
            input = new Scanner(dictionaryFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNextLine()) {
            String word = input.nextLine();
            words.add(word);
            prefixes.addPrefix(word);
        }
    }

    public boolean isValidPrefix(String word) {
        return prefixes.exists(word);
    }

    public boolean isValidWord(String word) {
        return word.length() >= 3 && words.contains(word);
    }

    private class PrefixTrie {

        TrieNode headNode;

        public PrefixTrie() {
            headNode = new TrieNode(' ');
        }

        public void addPrefix(String word) {
            TrieNode node = headNode;
            int limit = word.length() < PREFIX_LENGTH ? word.length() : PREFIX_LENGTH;
            for (int i = 0; i < limit; i++) {
                TrieNode child = new TrieNode(word.charAt(i));
                if (!node.children.contains(child)) {
                    node.children.add(child);
                    node = child;
                } else {
                    for (TrieNode trieNode : node.children) {
                        if (trieNode.equals(child)) {
                            node = trieNode;
                            break;
                        }
                    }
                }

            }
        }

        public boolean exists(String prefix) {
            if (prefix.isEmpty()) return true;
            TrieNode node = headNode;
            int limit = prefix.length() < PREFIX_LENGTH ? prefix.length() : PREFIX_LENGTH;
            MAIN: for (int i = 0; i < limit; i++) {
                TrieNode n = new TrieNode(prefix.charAt(i));
                for (TrieNode child : node.children) {
                    if (child.equals(n)) {
                        node = child;
                        continue MAIN;
                    }
                }
                return false;
            }
            return true;
        }

        private class TrieNode {
            char c;
            ArrayList<TrieNode> children;

            public TrieNode(char c) {
                children = new ArrayList<>();
                this.c = c;
            }

            @Override
            public int hashCode() {
                return Character.hashCode(c);
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof TrieNode)) return false;
                TrieNode o = (TrieNode) obj;
                return o.c == c;
            }
        }
    }
}
