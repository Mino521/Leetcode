class Solution {
    public int[] searchRange(int[] nums, int target){
        if(nums.length == 0)
            return new int[] {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false)-1;
        if(left > right || right == nums.length || nums[left] != target || nums[right] != target)
            return new int[] {-1, -1};
        return new int[] {left, right};
    }

    public int binarySearch(int[] nums, int target, boolean bool){
        int l = 0, r = nums.length-1;
        int ans = nums.length;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] > target || (bool && nums[mid] >= target)){
                r = mid -1;
                ans = mid;
            }
            else
                l = mid + 1;
        }
        return ans;
    }
}