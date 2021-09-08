class Solution {
    public int trailingZeroes(int n) {
        return dv(n,5);
    }
    public int dv(int n, int d){
        if(n < d)
            return 0;
        return n/d + dv(n, 5*d);
    }
}