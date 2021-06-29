class Solution {
    public boolean isMatch(String s, String p) {
        int a = s.length(), b = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[a+1][b+1];
        dp[0][0] = true;
        for(int i = 1; i <= b; i++){
            if(pc[i-1] == '*')
                dp[0][i] = true;
            else
                break;
        }
        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= b; j++){
                if(sc[i-1] == pc[j-1] || pc[j-1] == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(pc[j-1] == '*')
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
            }
        }
        return dp[a][b];
    }
}