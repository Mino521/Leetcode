class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0)
                nums[i] = n+1;
        }
        for(int i = 0; i < n; i++){
            int cur = Math.abs(nums[i]);
            if(cur <= n)
                nums[cur-1] = -Math.abs(nums[cur-1]);
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                return i+1;
        }
        return n+1;
    }
}