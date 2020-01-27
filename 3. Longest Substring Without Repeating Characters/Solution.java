/** 
 * Silding window
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int max = 0;
        for(int i = 0, j = 0; i < len;){
            char c = s.charAt(i);
            if(set.contains(c)){
                if(set.size() > max)
                    max = set.size();
                set.remove(s.charAt(j++));
            }
            else{
                set.add(c);
                i++;
            }
        }
        return max > set.size() ? max : set.size();
    }
}