class Solution {
    public int uniquePaths(int m, int n) {
        
//         int[][] dp = new int[m][n];
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         return f(m-1, n-1, dp);
        
        return func_lessSpace(m-1, n-1);
    }
    
    private static int func_lessSpace(int row, int col) {

        // declaring space optimsed 1d dp
        int[] prev = new int[col+1];
        for(int i = 0; i < col; i++) {
            prev[i] = -1;
        }


        for(int r = 0; r <= row; r++) {
            int[] temp = new int[col+1];
            for(int c = 0; c <= col; c++) {

                // base case
                if(r == 0 || c == 0){
                    temp[c] = 1;

                    continue;
                }

                if(c > 0) temp[c] = temp[c-1]+prev[c];

            }

            prev = temp;
        }

        return prev[col];
    }
    
    private static int f(int row, int col, int[][] dp) {
        if(row == 0 || col == 0) {
            return 1;
        }

        if(dp[row][col] != -1) return dp[row][col];


        int down = f(row - 1, col, dp);
        int right = f(row, col - 1, dp);


        return dp[row][col] = down + right;
    }
}