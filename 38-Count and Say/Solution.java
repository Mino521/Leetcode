class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for(int j = 0; j < ans.length(); j++){
                cnt++;
                if(j == ans.length()-1 || ans.charAt(j) != ans.charAt(j+1)){
                    sb.append(cnt);
                    sb.append(ans.charAt(j));
                    cnt = 0;
                }
            }
            ans = sb.toString();
        }
        return ans;
    }
}