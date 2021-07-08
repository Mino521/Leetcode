class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        long ans = x;
        while(ans * ans > x){
            ans = (ans + x/ans)/2;
        }
        return (int)ans;
    }
}