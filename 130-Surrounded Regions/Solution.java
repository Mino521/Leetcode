class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    if(check(board, i, j, visited)){
                        flip(board, i, j);
                    }
                }
            }
        }
    }

    public boolean check(char[][] board, int a, int b,boolean[][] visited){
        if(a < 0 || b < 0 || a > board.length-1 || b > board[0].length-1)
            return false;
        if(visited[a][b])
            return true;
        visited[a][b] = true;
        if(board[a][b] == 'X')
            return true;
        return check(board,a-1,b,visited) & check(board,a+1,b,visited) & check(board,a,b-1,visited) & check(board,a,b+1,visited);
    }

    public void flip(char[][] board, int a, int b){
        if(a < 0 || b < 0 || a > board.length-1 || b > board[0].length-1)
            return;
        if(board[a][b] == 'O'){
            board[a][b] = 'X';
            flip(board,a-1,b);
            flip(board,a+1,b);
            flip(board,a,b-1);
            flip(board,a,b+1);
        }
    }
}