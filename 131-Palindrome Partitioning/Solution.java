class Solution {
    public List<List<String>> partition(String s) {
        int len =s.length();
        boolean[][] isPar = new boolean[len][len];
        char[] cs = s.toCharArray();
        for(int i = 0; i < len; i++)
            Arrays.fill(isPar[i], true);
        for(int i = len-1; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                isPar[i][j] = (cs[i] == cs[j]) && isPar[i+1][j-1];
            }
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<>();
        findAns(isPar, ans, cs, 0, tmp);
        return ans;
    }

    public void findAns(boolean[][] isPar, List<List<String>> ans, char[] chars, int i, List<String> tmp){
        if(i == chars.length){
            ans.add(new ArrayList<String>(tmp));
            return;
        }
        for(int j = i; j < chars.length; j++){
            if(isPar[i][j]){
                tmp.add(new String(chars,i,j-i+1));
                findAns(isPar,ans,chars,j+1,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}