class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int right = 1; right <= s.length(); right++) {
            for (int left = right - 1; left >= 0; left--) {
                if (dp[left] && set.contains(s.substring(left, right))) {
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}