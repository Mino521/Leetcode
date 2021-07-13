class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        int cnt = 1;
        for(int i = 1; i < s.length()+1; i++){
            dp[i] = dp[i-1];
            if(chars[i-1] == '0'){
                if(i == 1 || !(chars[i-2] == '1' || chars[i-2] == '2'))
                    return 0;
            }
            if(chars[i-1] == '1' && (i < s.length() && chars[i] > '0') || chars[i-1] == '2' && (i < s.length() && chars[i] < '7' && chars[i] > '0')){
                if(i+1 < s.length() && chars[i+1] == '0')
                    continue;
                if(i > 1)
                    dp[i] = dp[i-1] + dp[i-2];
                else
                    dp[i] = dp[i-1] + 1;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}