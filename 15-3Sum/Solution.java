import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ans;
        for(int i = 0; i < n-2; i++){
            if(nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i];
            int second = i+1, third = n-1;
            while(second < third){
                if(nums[second]+nums[third] == target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[second],nums[third])));
                    second++;
                    third--;
                    while(second < third && nums[second] == nums[second-1])
                        second++;
                    while (second < third && nums[third] == nums[third+1])
                        third--;
                }
                else if(nums[second]+nums[third] < target)
                    second++;
                else
                    third--;
            }
        }
        return ans;
    }
}