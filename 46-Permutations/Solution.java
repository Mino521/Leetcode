import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new ArrayList<>();
        for(int n : nums){
            input.add(n);
        }

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        backtrack(n, input, res, 0);

        return res;
    }

    public void backtrack(int n, List<Integer> input, List<List<Integer>> res, int first){
        if(first == n)
            res.add(new ArrayList<Integer>(input));
        for(int i = first; i < n; i++){
            Collections.swap(input, first, i);
            backtrack(n, input, res, first+1);
            Collections.swap(input, first, i);
        }
    }
}