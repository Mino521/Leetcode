class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[2*k+1][prices.length];
        // initialize the state of the first day
        for(int i = 0; i < k; i++){
            dp[2*i+1][0] = -prices[0];
            dp[2*i+2][0] = 0;
        }
        // from the second day
        for(int i = 1; i < prices.length; i++){
            for(int j = 0; j < k; j++){
                dp[2*j+1][i] = Math.max(dp[2*j+1][i-1], dp[2*j][i]-prices[i]); // buy
                dp[2*j+2][i] = Math.max(dp[2*j+2][i-1], dp[2*j+1][i]+prices[i]); // sell
            }
        }
        return dp[2*k][prices.length-1];
    }
}