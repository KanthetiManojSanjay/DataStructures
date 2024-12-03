package tries;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 03/12/24.
 */
public class Trie {

    Node root;

    public Trie() {
        root = new Node('\0');
    }


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


    private void searchHelper(String document, int i, Map<String, Boolean> map) {
        Node temp = root;
        for (int j = i; j < document.length(); j++) {
            char ch = document.charAt(j);
            if (!temp.m.containsKey(ch)) {
                return;
            }
            temp = temp.m.get(ch);
            if (temp.isTerminal) {
                String out = document.substring(i, j + 1);
                map.put(out, true);
            }

        }
    }

    public void documentSearch(String document, String[] words) {

        // Searching
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < document.length(); i++) {
            searchHelper(document, i, map);
        }

        for (String word : words) {
            if (map.containsKey(word)) {
                System.out.printf("word: %s is present in document", word);
            } else {
                System.out.printf("word: %s is not present in document", word);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String document = "little cute cat loves to code in java & python";
        String words[] = {"cute cat", "ttle", "cat", "quick", "big"};

        Trie trie = new Trie();
        // create trie of words that we want to search
        for (String word : words) {
            trie.insert(word);
        }
        trie.documentSearch(document, words);
    }
}
