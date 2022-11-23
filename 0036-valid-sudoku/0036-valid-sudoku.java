class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int BOARD_LENGTH = 9;
        
        for(int i = 0; i < BOARD_LENGTH; i++){
            var row_checker = new HashSet();
            var col_checker = new HashSet();
            var subbox_checker = new HashSet();
            
            for(int j = 0; j < BOARD_LENGTH; j++){
                
                if(board[i][j] != '.' && !row_checker.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col_checker.add(board[j][i])) return false;
                
                if(i < (BOARD_LENGTH - 2) && i % 3 == 0){
                    
                    if(board[i][j] != '.' && !subbox_checker.add(board[i][j])) return false;
                    if(board[i+1][j] != '.' && !subbox_checker.add(board[i+1][j])) return false;
                    if(board[i+2][j] != '.' && !subbox_checker.add(board[i+2][j])) return false;
                }
                
                if((j+1) % 3 == 0) subbox_checker.clear();
                    
            }
        }
            
        return true;  
    }
}