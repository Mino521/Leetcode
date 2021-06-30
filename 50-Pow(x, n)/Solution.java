class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickPow(x,N) : 1.0/quickPow(x,-N);
    }

    public double quickPow(double x, long n){
        double ans = 1.0;
        while(n > 0){
            if((n&1) == 1)
                ans *= x;
            x *= x;
            n = n >> 1;
        }
        return ans;
    }
}