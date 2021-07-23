import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2)
            return n;
        int maxn = 0;
        for(int i = 0; i < n; i++){
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                if(i != j){
                    double key;
                    if(points[j][0]==points[i][0])
                        key = Double.POSITIVE_INFINITY;
                    else
                        key = (points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                    int cnt = map.getOrDefault(key, 1) + 1;
                    map.put(key, cnt);
                }
            }
            maxn = Math.max(map.values().stream().max(Integer::compare).get(),maxn);
        }
        return maxn;
    }
}