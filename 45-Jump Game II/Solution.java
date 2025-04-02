class Solution {
    public int jump(int[] nums) {
        int[] step = new int[nums.length];
        step[0] = 0;
        for(int i = 1; i < nums.length; i++){
            step[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 1; j <= nums[i] && i+j < nums.length; j++){
                step[i+j] = Math.min(step[i+j], step[i]+1);
            }
        }
        return step[nums.length-1];
    }
}

class GreedySolution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}