class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        stack.push(tokens[0]);
        for(int i = 1; i < tokens.length; i++){
            if(isNum(tokens[i])){
                stack.push(tokens[i]);
            }
            else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (tokens[i].charAt(0)){
                    case '+':
                        stack.push(String.valueOf(a+b));
                        break;
                    case '-':
                        stack.push(String.valueOf(b-a));
                        break;
                    case '*':
                        stack.push(String.valueOf(a*b));
                        break;
                    case '/':
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public boolean isNum(String s){
        return Character.isDigit(s.charAt(s.length()-1));
    }
}