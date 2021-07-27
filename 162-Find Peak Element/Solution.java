class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums[len-1] > nums[len-2])
            return len-1;
        boolean left = false, right = nums[0]-nums[1] > 0;
        for(int i = 1; i < len-1; i++){
            left = !right;
            right = nums[i]-nums[i+1]>0;
            if(left && right)
                return i;
        }
        return -1;
    }
}