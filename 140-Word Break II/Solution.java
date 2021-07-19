class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
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
        if(!dp[s.length()])
            return ans;
        Deque<String> path = new ArrayDeque<>();
        dfs(s,s.length(),set,dp,path,ans);
        return ans;
    }

    public void dfs(String s, int len, Set<String> set, boolean[] dp, Deque<String> path, List<String> ans){
        if(len == 0){
            ans.add(String.join(" ", path));
            return;
        }
        for(int i = len-1; i >= 0; i--){
            String suffix = s.substring(i,len);
            if(dp[i] && set.contains(suffix)){
                path.addFirst((suffix));
                dfs(s,i,set,dp,path,ans);
                path.removeFirst();
            }
        }
    }
}