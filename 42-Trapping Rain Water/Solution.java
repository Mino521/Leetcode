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

class Solution2 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int maxh = 0;
        for(int i = 0; i < height.length; i++){
            left[i] = Math.max(maxh, height[i]);
            maxh = left[i];
        }
        maxh = 0;
        for(int i = height.length-1; i >= 0; i--){
            right[i] = Math.max(maxh, height[i]);
            maxh = right[i];
        }
        int res = 0;
        for(int i = 0; i < height.length; i++){
            res += (Math.min(left[i], right[i]) - height[i]);
        }
        return res;
    }
}