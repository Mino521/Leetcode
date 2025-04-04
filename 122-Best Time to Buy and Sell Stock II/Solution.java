class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i <= prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i-1]);
        }
        return dp[prices.length][0];
    }
}

class SimpleSolution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += prices[i] - prices[i-1] > 0 ? prices[i] - prices[i-1] : 0;
        }
        return profit;
    }
}