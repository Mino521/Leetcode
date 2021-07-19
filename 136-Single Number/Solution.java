class Solution {
    public int singleNumber(int[] nums) {
        boolean[] booleans = new boolean[60001];
        for(int i = 0; i < nums.length; i++){
            booleans[nums[i]+30000] = !booleans[nums[i]+30000];
        }
        for(int i = 0; i < 60001; i++)
            if(booleans[i])
                return i-30000;
        return 0;
    }
}