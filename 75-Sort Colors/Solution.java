class Solution {
    public void sortColors(int[] nums) {
        for(int i = 0, j = nums.length-1, cur = 0; cur <= j;){
            if(nums[cur] == 0){
                int tmp = nums[i];
                nums[i] = nums[cur];
                nums[cur] = tmp;
                i++;
                cur++;
            }
            else if(nums[cur] == 2){
                int tmp = nums[j];
                nums[j] = nums[cur];
                nums[cur] = tmp;
                j--;
            }
            else
                cur++;
        }
    }
}