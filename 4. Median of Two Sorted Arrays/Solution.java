class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = (len+1) / 2;
        return findMean(nums1, nums2, k);
    }

    public double findMean(int[] nums1, int[] nums2, int k){
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return findMean(nums2, nums1, k);
        int imin = 0, imax = m;
        while(imin <= imax){
            int i = (imin + imax) / 2;
            int j = k - i;
            if(i < imax && nums2[j-1] > nums1[i])
                imin = i + 1; // i is too small
            else if (i > imin && nums1[i-1] > nums2[j])
                imax = i - 1; // i is too large
            else{ // i is perfect
                int maxLeft = 0; 
                if(i == 0)
                    maxLeft = nums2[j-1];
                else if(j == 0)
                    maxLeft = nums1[i-1];
                else
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if(((m+n)&1) == 1)
                    return maxLeft;

                int minRight = 0;
                if(i == m)
                    minRight = nums2[j];
                else if(j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums2[j],nums1[i]);
                return(maxLeft+minRight) / 2.0;
            }
        }
        return 0;
    }
}