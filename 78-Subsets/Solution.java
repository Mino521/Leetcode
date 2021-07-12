import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> t = new ArrayList<>();
        dfs(0, nums, t, ans);
        return ans;
    }

    public void dfs(int cur, int[] nums, List<Integer> t, List<List<Integer>> ans){
        if(cur == nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur+1, nums, t, ans);
        t.remove(t.size()-1);
        dfs(cur+1, nums, t, ans);
    }
}