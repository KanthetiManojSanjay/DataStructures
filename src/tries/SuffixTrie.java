package tries;

/**
 * @author kansanja on 03/12/24.
 */
public class SuffixTrie {
    Node root;

    public SuffixTrie() {
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

    // Suffix trie o(D^2)
    void suffixTrie_insert(String word) {
        for (int i = 0; i < word.length(); i++) {
            // hello , ello, llo, lo
            insert(word.substring(i));
        }
    }

    public static void main(String[] args) {
        String suffixes[] = {"hello", "lo", "ell"};
        String input = "hello";

        SuffixTrie trie = new SuffixTrie();
        trie.suffixTrie_insert(input);
        for (String word : suffixes) {
            if (trie.search(word)) {
                System.out.print("Yes ");
            } else {
                System.out.print("No ");
            }
        }
    }

}
