import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] strings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits == null || digits.length() == 0)
            return new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        int n = digits.length();
        int cnt = 1;
        for(int i = 0; i < n; i++){
            int d = digits.charAt(i)-'0';
            String target = strings[d];
            for(int j = 0; j < cnt; j++){
                String s = queue.poll();
                for(int k = 0; k < target.length(); k++){
                    queue.add(s+target.charAt(k));
                }
            }
            cnt *= target.length();
        }
        return new ArrayList<>(queue);
    }
}