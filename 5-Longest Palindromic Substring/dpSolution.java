class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)  // len = 1, must satisfy
        	return s;

        int maxl = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        char[] str = s.toCharArray();
        // initialize
        for(int i = 0; i < len; i++)
        	dp[i][i] = true;

        // dp, state transfer
        for(int j = 0; j < len; j++)
        	for(int i = 0; i < j; i++){
        		if(str[i] != str[j])
        			dp[i][j] = false;
        		else{
        			if(j-i < 3)
        				dp[i][j] = true;
        			else
        				dp[i][j] = dp[i+1][j-1];
        		}
        		if(dp[i][j] && j-i+1 > maxl){
        			maxl = j-i+1;
        			start = i;
        		}
        	}
        return s.substring(start, start+maxl);
    }
}