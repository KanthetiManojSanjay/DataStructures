package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	
	
	public static boolean isValid(String str) {
		Map<Character,Character> map=new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<str.length();i++) {
			char brack = str.charAt(i);
			if(map.containsKey(brack)) {
				stack.push(brack);
			}else {
				if(stack.isEmpty()) {
					return false;
				}
				char target=stack.pop();
				if(!map.containsKey(target) || map.get(target)!=brack) {
					return false;
				}
				
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str="]{()}";
		boolean valid = isValid(str);
		System.out.print("Valid Parenthesis is :"+ valid);

	}

}
