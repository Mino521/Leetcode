import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length; i++){
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{')
                stack.add(chars[i]);
            else {
                if(stack.empty())
                    return false;
                char c = stack.pop();
                if((chars[i] == ')' && c == '(')
                || (chars[i] == ']' && c == '[')
                || (chars[i] == '}' && c == '{'))
                    continue;
                else
                    return false
            }
        }
        return stack.empty();
    }
}