// package tries;

public class Trie {
    
    private Node root;

    public Trie() {
        root = new Node();
    }

    static class Node {
        Node[] arr = new Node[26];
        boolean isTerminal = false;
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.arr[word.charAt(i)-'a']==null) {
                node.arr[word.charAt(i)-'a'] = new Node();
            }
            node = node.arr[word.charAt(i)-'a'];
        }
        node.isTerminal = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch:word.toCharArray()) {
            if(node.arr[ch - 'a']==null){
                return false;
            }
            node = node.arr[ch-'a'];
        }
        return node.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.arr[ch-'a']==null) {
                return false;
            }
            node = node.arr[ch-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Inserting words: Striver, Striving, String, Strike");
        trie.insert("striver");
        trie.insert("striving");
        trie.insert("string");
        trie.insert("strike");

        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));
    }
}
                         