class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = (len+1) / 2;
        int even = 1-(k*2-len);
        if(even == 1)
            return (findk(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, k) + findk(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, k+1))/2.0;
        return findk(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, k);
    }

    public double findk(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k){
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;
        if(m > n)  // keep len of nums1 less than nums2
            return findk(nums2, nums1, start2, end2, start1, end1, k);
        // can directly find solution
        if(m == 0)
            return nums2[start2+k-1];
        if(k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(end1,k/2-1);
        int j = start2 + Math.min(end2,k/2-1);
        if(nums1[i]<nums2[j])
            return findk(nums1, nums2, i+1, end1, start2, end2, k-i+start1-1);
        else
            return findk(nums1, nums2, start1, end1, j+1, end2, k-j+start2-1);
    }
}