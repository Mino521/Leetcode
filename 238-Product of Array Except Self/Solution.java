class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        int m = 1;
        for(int i = 0; i < nums.length; i++){
            a[i] = m*nums[i];
            m = a[i];
        }
        m = 1;
        for(int i = nums.length-1; i >= 0; i--){
            b[i] = m*nums[i];
            m = b[i];
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++){
            res[i] = (i>0?a[i-1]:1) * (i<res.length-1?b[i+1]:1);
        }
        return res;
    }
}

class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int cnt0 = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                cnt0++;
                index = i;
            }
        }
        int[] res = new int[nums.length];
        int answer = 1;
        if(cnt0 > 1)
            return res;
        else if (cnt0 == 1){
            for(int i = 0; i < nums.length; i++){
                if(i != index){
                    answer *= nums[i];
                }
            }
            res[index] = answer;
            return res;
        }
        else{
            for(int i = 0; i < nums.length; i++){
                answer *= nums[i];
            }
            for(int i = 0; i < nums.length; i++){
                res[i] = answer / nums[i];
            }
        }
        return res;
    }
}
