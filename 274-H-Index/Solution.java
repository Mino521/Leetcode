class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 1;
        for(; i <= citations.length; i++){
            if(i > citations[citations.length-i])
                return i-1;
        }
        return citations.length;
    }
}

public class Solution2 {
    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}