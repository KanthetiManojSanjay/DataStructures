package tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kansanja on 29/03/24.
 */
public class Trie {

    Node root;

    public Trie() {
        root = new Node('\0');
    }

    // Insertion
    void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.m.containsKey(ch)) {
                Node n = new Node(ch);
                temp.m.put(ch, n);
            }
            temp = temp.m.get(ch);
        }
        temp.isTerminal = true;
    }

    //Searching
    boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.m.containsKey(ch)) {
                return false;
            }
            temp = temp.m.get(ch);
        }
        return temp.isTerminal;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String words[] = {"hello", "he", "apple", "aple", "news"};
        for (String word : words) {
            trie.insert(word);
        }
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        System.out.println(trie.search(key));
    }

}

class Node {
    char data;
    Map<Character, Node> m;
    boolean isTerminal;

    Node(char d) {
        data = d;
        m = new HashMap<>();
        isTerminal = false;
    }
}
