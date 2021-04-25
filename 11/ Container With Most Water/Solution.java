class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = 0;
        while (l < r){
            int size = Math.min(height[l],height[r])*(r-l);
            if (max < size)
                max = size;
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}