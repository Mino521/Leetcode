import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] row = new int[9];
    private int[] col = new int[9];
    private int[][] box = new int[3][3];
    private List<int[]> space = new ArrayList<>();
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int digit = board[i][j] - '0';
                    flip(i,j,digit-1);
                }
            }
        }

        while (true){
            boolean modified = false;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(board[i][j] == '.'){
                        int mask = ~(row[i]|col[j]|box[i/3][j/3]) & 0x1FF;
                        if((mask & (mask - 1)) == 0){
                            int digit = Integer.bitCount(mask-1);
                            flip(i,j,digit);
                            board[i][j] = (char)(digit+'1');
                            modified = true;
                        }
                    }
                }
            }
            if(!modified)
                break;
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    space.add(new int[] {i,j});
            }
        }

        dfs(board, 0);
    }

    public void flip(int i, int j, int digit){
        row[i] ^= (1 << digit);
        col[j] ^= (1 << digit);
        box[i/3][j/3] ^= (1 << digit);
    }

    public void dfs(char[][] board, int pos){
        if(pos == space.size()){
            valid = true;
            return;
        }

        int[] s = space.get(pos);
        int i = s[0], j = s[1];
        int mask = ~(row[i]|col[j]|box[i/3][j/3]) & 0x1FF;
        for( ; mask != 0 && !valid; mask &= (mask-1)){
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask-1);
            flip(i,j,digit);
            board[i][j] = (char)(digit+'1');
            dfs(board,pos+1);
            flip(i,j,digit);
        }
    }
}