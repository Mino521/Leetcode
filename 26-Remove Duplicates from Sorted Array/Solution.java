class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] nc = nums.clone();
        int mem = nums[0];
        int cnt = 1;
        for(int i = 1, j = 1; i < nums.length; i++){
            if(nums[i] == mem)
                continue;
            mem = nc[i];
            cnt++;
            nums[j++] = mem;
        }
        return cnt;
    }
}