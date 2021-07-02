import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1, int[] interval2){
                return interval1[0]-interval2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int i = 0, j = 0; i < intervals.length; i = j){
            int l = intervals[i][0], r = intervals[i][1];
            j = i+1;
            for(; j < intervals.length; j++){
                int ll = intervals[j][0], rr = intervals[j][1];
                if(ll > r){
                    res.add(new int[] {l,r});
                    i = j;
                    break;
                }
                if(rr > r){
                    i = j;
                    r = rr;
                }
            }
            if(i != j)
                res.add(new int[] {l,r});
            //System.out.println(l+" " + r + " "+i);
        }
        return res.toArray(new int[res.size()][]);
    }
}