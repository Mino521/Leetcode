class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(Character.isDigit(ch)){
                    int n = ch-'0';
                    int cnt = ++row[i][n-1];
                    if(cnt > 1)
                        return false;
                    cnt = ++col[j][n-1];
                    if(cnt > 1)
                        return false;
                    cnt = ++box[(i/3+1)+(j/3*3)-1][n-1];
                    if(cnt > 1)
                        return false;
                }
            }
        }
        return true;
    }
}