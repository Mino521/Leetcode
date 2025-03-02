class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int k = 1;
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == pre){
                if(k++ < 2){
                    nums[cnt++] = nums[i];
                }
            }
            else {
                nums[cnt++] = nums[i];
                pre = nums[i];
                k = 1;
            }
        }
        return cnt;
    }
}