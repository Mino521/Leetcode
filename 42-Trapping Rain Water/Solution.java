import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty())
                    break;
                int left = stack.peek();
                int width = i-left-1;
                int h = Math.min(height[left], height[i]) - height[top];
                ans += width*h;
            }
            stack.push(i);
        }
        return ans;
    }
}