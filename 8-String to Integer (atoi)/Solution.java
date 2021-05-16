class Solution {
	public int myAtoi(String s) {
		if(s == null || s.length() == 0)
			return 0;
		s = s.trim();
		if(s.length() == 0)
			return 0;
		int sign = 1;
		int start = 0;
		if(s.charAt(0) == '-'){
			start++;
			sign = -1;
		}
		else if(s.charAt(0) == '+')
			start++;
		char[] cs = s.toCharArray();
		long sum = 0;
		for(int i = start; i < cs.length; i++){
			if(!Character.isDigit(cs[i])){
				return (int)sum*sign;
			}
			sum = sum*10 + (cs[i]-'0');
			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int)sum*sign;
	}
}