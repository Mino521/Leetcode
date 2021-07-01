import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();
        int a = 0, c = 0;
        int b = matrix.length-1, d = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(a <= b && c <= d){
            for(int i = c; i <= d; i++)
                ans.add(matrix[a][i]);
            a++;
            for(int i = a; i <= b; i++)
                ans.add(matrix[i][d]);
            d--;
            if(a <= b && c <= d){
                for(int i = d; i >= c; i--)
                    ans.add(matrix[b][i]);
                b--;
                for(int i = b; i >= a; i--)
                    ans.add(matrix[i][c]);
                c++;
            }
        }
        return ans;
    }
}