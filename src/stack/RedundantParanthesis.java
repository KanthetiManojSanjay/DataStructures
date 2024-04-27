package stack;

import java.util.Stack;

/**
 * @author kansanja on 25/04/24.
 */
public class RedundantParanthesis {

    public static boolean checkRedundant(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ')') {
                // push all characters except closed brackets i.e ')'
                stack.push(str.charAt(i));
            } else {
                boolean operator_found = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    Character top = stack.peek();
                    // check for operator presence and update boolean flag is found
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operator_found = true;
                    }
                    stack.pop();
                }
                // to remove open bracket for closing bracket that was encountered during iteration
                stack.pop();

                if (!operator_found) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b)+c)";
//        String str = "((a+b)+(c))";
        if (checkRedundant(str)) {
            System.out.println("Contains Redundant Parenthesis");
        } else {
            System.out.println("Doesn't Contains Redundant Parenthesis");
        }

    }


}
