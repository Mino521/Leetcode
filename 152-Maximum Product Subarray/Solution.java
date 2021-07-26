class Solution {
    public int maxProduct(int[] nums) {
        int maxp = nums[0], minp = nums[0], ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int a = maxp*nums[i], b = minp*nums[i];
            maxp = Math.max(a, Math.max(b, nums[i]));
            minp = Math.min(a, Math.min(b, nums[i]));
            ans = Math.max(maxp, ans);
        }
        return ans;
    }
}