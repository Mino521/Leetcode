class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int ans = 0, cur = 0;
        for(int i = 0, j = 0, cnt = 0; cnt < n && j < n;){
            if(cur >= 0){
                cur = cur + gas[i%n] - cost[i%n];
                cnt++;
                i++;
            }
            else {
                cur = cur - gas[j] + cost[j];
                cnt--;
                j++;
                ans = j;
            }
        }
        if(cur < 0 || ans == n)
            return -1;
        return ans;
    }
}