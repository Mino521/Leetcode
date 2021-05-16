class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        String pre = strs[0];
        for(int i = 1; i < strs.length; i++){
            pre = commonPrefix(pre, strs[i]);
            if(pre == "")
                return pre;
        }
        return pre;
    }

    public String commonPrefix(String s1, String s2){
        if(s2.length() == 0)
            return "";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0;
        for(; i < Math.min(c1.length,c2.length); i++){
            if(c1[i] != c2[i])
                break;
        }
        return s1.substring(0,i);
    }
}