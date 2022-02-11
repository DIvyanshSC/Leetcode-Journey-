class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return f(m, n, dp);
    }
    
    private static int f(int row, int col, int[][] dp) {
        if(row == 1 || col == 1) {
            return 1;
        }

        if(dp[row][col] != -1) return dp[row][col];


        int down = f(row - 1, col, dp);
        int right = f(row, col - 1, dp);


        return dp[row][col] = down + right;
    }
}