import java.util.Arrays;

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCnt = 0;
                if(i-1 >= 0 && j-1 >= 0 && copy[i-1][j-1] == 1) liveCnt++;
                if(i-1 >= 0 && copy[i-1][j] == 1) liveCnt++;
                if(i-1 >= 0 && j+1 < copy[0].length && copy[i-1][j+1] == 1) liveCnt++;
                if(j-1 >= 0 && copy[i][j-1] == 1) liveCnt++;
                if(j+1 < copy[0].length && copy[i][j+1] == 1) liveCnt++;
                if(i+1 < copy.length && j-1 >= 0 && copy[i+1][j-1] == 1) liveCnt++;
                if(i+1 < copy.length && copy[i+1][j] == 1) liveCnt++;
                if(i+1 < copy.length && j+1 < copy[0].length && copy[i+1][j+1] == 1) liveCnt++;

                if(copy[i][j] == 1){
                    if(liveCnt < 2 || liveCnt > 3){
                        board[i][j] = 0;
                    }
                    else {
                        board[i][j] = 1;
                    }
                }
                else {
                    if(liveCnt == 3){
                        board[i][j] = 1;
                    }
                    else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
}