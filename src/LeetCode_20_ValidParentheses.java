/**
 * Created by Gene on 6/12/17.
 */
public class LeetCode_20_ValidParentheses {
    //Solution 60% Deque
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.offerLast(')');
            else if (c == '{')
                stack.offerLast('}');
            else if (c == '[')
                stack.offerLast(']');
            else if (stack.isEmpty() || stack.pollLast() != c)
                return false;
        }
        return stack.isEmpty();
    }

    /*
    //Solution 80% Stack
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

    	for (char c : s.toCharArray()) {
    		if (c == '(')
    			stack.push(')');
    		else if (c == '{')
    			stack.push('}');
    		else if (c == '[')
    			stack.push(']');
    		else if (stack.isEmpty() || stack.pop() != c)
    			return false;
    	}
    	return stack.isEmpty();
    }
    */
    /*
    //41% keen+Stack
    public boolean isValid(String s) {

        //corner case
        if (s == null || s.length() == 0){
            return true;
        }

        if (s.length() == 1){
            return false;
        }
        //main
        Stack<Character> stack = new Stack<>();
        char[] ca = s.toCharArray();

        for (char c:ca){

            if (c == '{' ||  c == '[' || c == '('){
                stack.push(c); //(..)
            }

            else{ //(c == '}' ||  c == ']' || c == ')'){
                if (stack.size() == 0){  //meet right side first
                    return false;
                }
                char left = stack.pop();
                if (left == '{' && c == '}'|| //(..)
                    left == '[' && c == ']'||
                    left == '(' && c == ')' ){ //(..)
                    continue;
                }else{  //(..)
                    return false;
                }

            }
        }
        return stack.isEmpty();//true; (..)
    }
    */
    /*
    //Keen 12%
    public boolean isValid(String s) {

        //corner case
        if (s == null || s.length() == 0){
            return true;
        }

        if (s.length() == 1){
            return false;
        }
        //main

        Deque<Character> stack = new ArrayDeque<>();
        char[] ca = s.toCharArray();

        for (char c:ca){

            if (c == '{' ||  c == '[' || c == '('){
                stack.offerLast(c); //(..)
            }

            else{ //(c == '}' ||  c == ']' || c == ')'){
                if (stack.size() == 0){  //meet right side first
                    return false;
                }
                char left = stack.pollLast();
                if (left == '{' && c == '}'|| //(..)
                    left == '[' && c == ']'||
                    left == '(' && c == ')' ){ //(..)
                    continue;
                }else{  //(..)
                    return false;
                }

            }
        }
        return stack.isEmpty();//true; (..)
    }
    */
}
