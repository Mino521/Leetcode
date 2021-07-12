class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m-- + n-- - 1; i >= 0;){
            if(m < 0){
                while(i >= 0){
                    nums1[i] = nums2[i];
                    i--;
                }
                break;
            }
            if(n < 0)
                break;
            if(nums1[m] > nums2[n]){
                nums1[i] = nums1[m--];
            }
            else{
                nums1[i] = nums2[n--];
            }
            i--;
        }
    }
}