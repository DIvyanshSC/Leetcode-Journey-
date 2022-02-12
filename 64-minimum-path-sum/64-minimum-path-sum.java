class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

//        return f(m-1, n-1, grid, dp);
        return tabulated(n-1, m-1, grid, dp);
        

    }

    private static int tabulated(int row, int col, int[][] grid, int[][] dp) {
        for(int r = 0; r <= row; r++) {
            for(int c = 0; c <= col; c++) {

                if(r == 0 && c == 0) {
                    dp[r][c] = grid[r][c];
                }

                else {

                    int right = grid[r][c];
                    int down = grid[r][c];

                    if (c > 0) right += dp[r][c - 1];
                    else right += (int)Math.pow(10, 9);

                    if (r > 0) down += dp[r - 1][c];
                    else down += (int)Math.pow(10, 9);

                    dp[r][c] = Math.min(right, down);
                }
            }
        }

        return dp[row][col];
    
    }
}