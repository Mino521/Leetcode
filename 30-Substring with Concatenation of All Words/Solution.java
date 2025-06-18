import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int wordsLen = words.length;
        List<Integer> ans = new ArrayList<>();

        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> cnt = new HashMap<>();
            // 用len记录进入窗口的子串长度，不足则继续入串，当遇到不符合的串就重置cnt和len
            for (int j = i, len = 0; j <= s.length() - wordLen; j += wordLen) {
                String inWord = s.substring(j, j + wordLen);
                // 不符合的重置哈希表和子串长度
                if (!wordMap.containsKey(inWord)) {
                    cnt.clear();
                    len = 0;
                    continue;
                }
                // 符合的入串
                cnt.merge(inWord, 1, Integer::sum);
                len++;
                // 子串左端点 = j + 这次入串的长 - 整个窗口长
                int left = j + wordLen - wordsLen * wordLen;
                // 不足长的继续入串
                if (len < wordsLen) {
                    continue;
                }
                // 满足的串联子串更新ans
                if (cnt.equals(wordMap)) {
                    ans.add(left);
                }
                // 出串
                cnt.merge(s.substring(left, left + wordLen), -1, Integer::sum);
                len--;
            }
        }

        return ans;
    }
}