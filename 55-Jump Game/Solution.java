class Solution {
    public boolean canJump(int[] nums) {
        int maxd = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i > maxd)
                return false;
            maxd = Math.max(maxd, i+nums[i]);
        }
        return (maxd >= nums.length-1);
    }
}