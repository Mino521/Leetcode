class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] == val){
                k--;
                j++;
            }
            else {
                nums[i++] = nums[j++];
            }
        }
        return k;
    }
}