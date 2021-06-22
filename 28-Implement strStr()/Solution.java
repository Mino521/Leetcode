class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        int[] next = new int[needle.length()];

        for(int i = 1, j = 0; i < p.length; i++){
            while(j > 0 && p[i] != p[j])
                j = next[j-1];
            if(p[i] == p[j])
                j++;
            next[i] = j;
        }

        for(int i = 0, j = 0; i < s.length; i++){
            while(j > 0 && s[i] != p[j])
                j = next[j-1];
            if(s[i] == p[j])
                j++;
            if(j == p.length)
                return i-p.length+1;
        }
        return -1;
    }
}