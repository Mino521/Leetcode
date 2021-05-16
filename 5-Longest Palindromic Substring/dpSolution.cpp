class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.size();
        if(len < 2)
        	return s;

        char str[len+1];
		strcpy(str, s.c_str());

		int dp[len][len];
		memset(dp,0,sizeof(dp));
		for(int i = 0; i < len; i++)
			dp[i][i] = 1;
		int maxl = 1;
		int start = 0;

		for(int j = 0; j < len; j++)
			for(int i = 0; i < j; i++){
				if(str[i] == str[j]){
					if(j-i < 3)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i+1][j-1];
				}
				if(dp[i][j] && j-i+1 > maxl){
					maxl = j-i+1;
        			start = i;
				}
			}

		return s.substr(start, maxl);
    }
};