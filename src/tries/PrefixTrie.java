package tries;

import java.util.Scanner;

/**
 * @author kansanja on 29/03/24.
 * Trie is a generic Tree like structure which can have 0 or more children
 * Efficient for information retrival
 * Searches in optimal time O(key length) but uses extra storage
 */

// Prefix Trie as prefix i.e common prefix letters for different words are in same branch
public class PrefixTrie {

    Node root;

    public PrefixTrie() {
        root = new Node('\0');
    }

    // Insertion O(keyLength) for 1 word so N words we can multiply with N
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

    //Searching O(keyLength)
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
        PrefixTrie trie = new PrefixTrie();
        String words[] = {"hello", "he", "apple", "aple", "news"};
        for (String word : words) {
            trie.insert(word);
        }
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        System.out.println(trie.search(key));

    }

}


