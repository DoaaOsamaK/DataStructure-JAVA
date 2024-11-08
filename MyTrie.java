package datastructure;

public class MyTrie {

    private TrieNode root;

    // Constructor: Initializes the Trie
    public MyTrie() {
        root = new TrieNode();
    }

    // Inner class representing a Trie Node
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 English alphabet letters
        boolean isEndOfWord = false;
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    // Searches for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEndOfWord;
    }

    // Checks if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    // Returns the string representation of the Trie (for debugging purposes)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(root, sb, "");
        return sb.toString();
    }

    // Helper method for generating string representation of the Trie
    private void toStringHelper(TrieNode node, StringBuilder sb, String prefix) {
        if (node == null) {
            return;
        }
        if (node.isEndOfWord) {
            sb.append(prefix).append("\n");
        }
        for (char c = 'a'; c <= 'z'; c++) {
            TrieNode child = node.children[c - 'a'];
            if (child != null) {
                toStringHelper(child, sb, prefix + c);
            }
        }
    }
}
