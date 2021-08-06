class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        // determine positive or negative
        if(numerator < 0 ^ denominator < 0)
            sb.append("-");
        // convert to long, avoid overflow
        long a = Math.abs(Long.valueOf(numerator)), b = Math.abs(Long.valueOf(denominator));
        // calculate integer part
        sb.append(String.valueOf(a/b));
        // calculate fraction part
        long remainder = a % b;
        if(remainder == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0){
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder/b));
            remainder %= b;
        }
        return sb.toString();
    }
}