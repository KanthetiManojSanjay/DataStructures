package tries;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 03/12/24.
 */
public class Node {
    char data;
    Map<Character, Node> m;
    boolean isTerminal;

    Node(char d) {
        data = d;
        m = new HashMap<>();
        isTerminal = false;
    }
}
