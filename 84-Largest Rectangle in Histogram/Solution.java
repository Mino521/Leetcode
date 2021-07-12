import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 1)
            return heights[0];
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int h = heights[stack.pop()];
                while(!stack.isEmpty() && heights[stack.peek()] == h){
                    stack.pop();
                }
                int w = stack.isEmpty() ? i : i-stack.peek()-1;
                ans = Math.max(ans, w*h);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h = heights[stack.pop()];
            while(!stack.isEmpty() && heights[stack.peek()] == h){
                stack.pop();
            }
            int w = stack.isEmpty() ? len : len-stack.peek()-1;
            ans = Math.max(ans, w*h);
        }
        return ans;
    }
}