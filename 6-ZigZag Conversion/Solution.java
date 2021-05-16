class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2)
        	return s;
        int len = s.length();
        int cycle = 2*numRows-2;
        StringBuilder strB = new StringBuilder();
        for(int i = 0; i < numRows; i++){
        	for(int j = 0; j+i < len; j+=cycle){
        		strB.append(s.charAt(j+i));
        		if (i != 0 && i != numRows-1 && j+cycle-i < len)
                    strB.append(s.charAt(j+cycle-i));
        	}
        }
        return strB.toString();
    }
};