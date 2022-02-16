class Solution {
    public boolean exist(char[][] board, String word) {
        char[] c = word.toCharArray();
        int k = 0;
        boolean ans = false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exist(board, i, j, c, 0)) {
                    ans = true;
                    break;
                } 
            }
        }
        
        return ans;
    }
    
    private boolean exist(char[][] board, int i, int j, char[] c, int len) {
        
        if(i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        
        if(board[i][j] != c[len]) {
            return false;
        }
        
        if(len == c.length - 1) {
            return true;
        }
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        boolean check = exist(board, i, j + 1, c, len + 1) ||
                        exist(board, i, j - 1, c, len + 1) ||
                        exist(board, i + 1, j, c, len + 1) ||
                        exist(board, i - 1, j, c, len + 1);
        
        board[i][j] = temp;
        
        return check;
    }
}