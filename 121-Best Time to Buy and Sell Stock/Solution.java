class Solution {
    public int maxProfit(int[] prices) {
        int minp = prices[0];
        int maxp = 0;
        for(int i = 1; i< prices.length; i++){
            minp = prices[i] < minp ? prices[i] : minp;
            maxp = prices[i]-minp > maxp ? prices[i]-minp : maxp;
        }
        return maxp;
    }
}