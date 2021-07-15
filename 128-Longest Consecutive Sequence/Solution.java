class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        int longest = 0;
        for(int i : set){
            if(set.contains(i-1))
                continue;
            int cnt = 1;
            int cur = i;
            while (set.contains(++cur))
                cnt++;
            if(cnt > longest)
                longest = cnt;
        }
        return longest;
    }
}