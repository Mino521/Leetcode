class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return -1;
        if(len == 1)
            return nums[0] == target ? 0 : -1;
        int l = 0, r = len-1;
        while (l <= r){
            if(r-l < 2){
                if(nums[l] == target)
                    return l;
                if(nums[r] == target)
                    return r;
                return -1;
            }
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                if(nums[l] > target && nums[l] < nums[mid])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else {
                if(nums[r] < target && nums[r] > nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }
}