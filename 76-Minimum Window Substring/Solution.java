import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();
        for(int i = 0; i < ct.length; i++){
            tm.put(ct[i], tm.getOrDefault(ct[i], 0)+1);
        }
        int l = 0, r = 0, len = s.length()+1, start = 0;
        int cnt = 0;
        while(r < s.length()){
            if(!tm.containsKey(cs[r])){
                r++;
                continue;
            }
            if(sm.getOrDefault(cs[r], 0) < tm.get(cs[r])){
                cnt++;
            }
            sm.put(cs[r], sm.getOrDefault(cs[r], 0)+1);
            r++;
            while(cnt == ct.length){
                if(r-l < len){
                    len = r-l;
                    start = l;
                }
                if(!tm.containsKey(cs[l])){
                    l++;
                    continue;
                }
                if(sm.get(cs[l]).equals(tm.get(cs[l]))){
                    cnt--;
                }
                sm.put(cs[l], sm.get(cs[l])-1);
                l++;
            }
        }
        if(len == s.length()+1)
            return "";
        return s.substring(start, start+len);
    }
}