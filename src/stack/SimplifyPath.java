package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kansanja on 27/04/24.
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {

        // Tokenisation & filtering
        String[] splitString = path.split("/");
        List<String> tokens = new ArrayList<>();
        for (String split : splitString) {
            if (split.equalsIgnoreCase(".") || split == "")
                continue;
            tokens.add(split);
        }

        // Handle
        Stack<String> stack = new Stack<>();
        if (path.charAt(0) == '/') {
            // denotes that our path is Absolute path(wrt root dir)
            stack.push("");
        }

        for (String token : tokens) {
            if (token.equalsIgnoreCase("..")) {
                // handle relative path
                if (stack.size() == 0 || stack.peek() == "..") { // Ex:  ../../a/b/c/../d
                    stack.push("..");
                } else if (stack.peek() != "") {  // Handle Absolute path scenario by avoiding removal of ""
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }

        //single element
        if (stack.size() == 1 && stack.peek() == "") {
            return "/";
        }

        //combine all elements in the stack to get the result
        int i = 0;
        String result = "";
        for (String str : stack) {
            if (i != 0) {
                result += "/";
            }
            i++;
            result += str;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "/../x/y/../z/././w/a///../../c/./";
        String result = simplifyPath(str);
        System.out.println(result);
    }
}
