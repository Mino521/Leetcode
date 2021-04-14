public class Solution {
    public boolean isMatch(String s, String p) {
        char[] c1 = s.toCharArray();
        char[] c2 = p.toCharArray();
        boolean[][] dp = new boolean[c1.length+1][c2.length+1];
        dp[0][0] = true;
        for(int i = 0; i < c1.length+1; i++){
            for(int j = 1; j < c2.length+1; j++){
                if(c2[j-1] != '*'){
                    if(i > 0 && (c1[i-1] == c2[j-1] || c2[j-1] == '.'))
                        dp[i][j] = dp[i-1][j-1];
                }
                else {
                    if(j > 1)
                        dp[i][j] = dp[i][j-2];
                    if(i > 0 && j > 1 && (c1[i-1] == c2[j-2] || c2[j-2] == '.'))
                        dp[i][j] |= dp[i-1][j];
                }
            }
        }
        return dp[c1.length][c2.length];
    }
}
