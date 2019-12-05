import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        
        for(Character c : s.toCharArray()){
        	if(c == '(')
        		stack.push(')');
        	else if(c == '[')
        		stack.push(']');
        	else if(c == '{')
        		stack.push('}');
        	else{
        		if(stack.isEmpty() || stack.pop() != c)
        			return false;
        	}
        }
        return stack.isEmpty();
    }
}
