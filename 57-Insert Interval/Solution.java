import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();
        boolean finish = false;
        int nL = newInterval[0], nR = newInterval[1];
        for(int i = 0; i < intervals.length; i++){
            if(!finish){
                if(intervals[i][0] > newInterval[1]){
                    ansList.add(new int[]{nL, nR});
                    finish = true;
                    ansList.add(intervals[i]);
                }
                else if(intervals[i][1] < newInterval[0]){
                    ansList.add(intervals[i]);
                }
                else {
                    nL = Math.min(nL, intervals[i][0]);
                    nR = Math.max(nR, intervals[i][1]);
                }
            }
            else {
                ansList.add(intervals[i]);
            }
        }

        if (!finish) {
            ansList.add(new int[]{nL, nR});
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}