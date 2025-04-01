class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        if(k == 0)
            return;
        int[] copy = Arrays.copyOf(nums, nums.length);
        for(int i = 0, j = l-k; i < l; i++, j=(j+1)%l){
            nums[i] = copy[j];
        }
    }
}

class O1SpaceSolution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;

        reverse(nums, 0, l - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, l - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}