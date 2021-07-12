class Solution {
    public boolean exist(char[][] board, String word) {
        int a = board.length, b = board[0].length;
        char[] wc = word.toCharArray();
        boolean[][] check = new boolean[a][b];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(board[i][j] == wc[0]){
                    check[i][j] = true;
                    if( dfs(i,j,board,wc,1,check) )
                        return true;
                    check[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, char[][] board, char[] word, int cur, boolean[][] check){
        if(cur == word.length)
            return true;
        if(x-1 >= 0 && !check[x-1][y]){
            if(board[x-1][y] == word[cur]){
                check[x-1][y] = true;
                if(dfs(x-1, y, board, word, cur+1, check))
                    return true;
                check[x-1][y] = false;
            }
        }
        if(y-1 >= 0 && !check[x][y-1]){
            if(board[x][y-1] == word[cur]){
                check[x][y-1] = true;
                if(dfs(x, y-1, board, word, cur+1, check))
                    return true;
                check[x][y-1] = false;
            }
        }
        if(x+1 < board.length && !check[x+1][y]){
            if(board[x+1][y] == word[cur]){
                check[x+1][y] = true;
                if(dfs(x+1, y, board, word, cur+1, check))
                    return true;
                check[x+1][y] = false;
            }
        }
        if(y+1 < board[0].length && !check[x][y+1]){
            if(board[x][y+1] == word[cur]){
                check[x][y+1] = true;
                if(dfs(x, y+1, board, word, cur+1, check))
                    return true;
                check[x][y+1] = false;
            }
        }
        return false;
    }
}