class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return f(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        int ans = pathCount(obstacleGrid, m-1, n-1, dp);
        System.out.println(m-1);
        System.out.println(n-1);
        System.out.println();

        for(int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();

        return ans;
    }
    
    private static int pathCount(int[][] maze, int r, int c, int[][] dp) {
        
        if(r < 0 || c < 0) {
            return 0;
        }
        
        if((r>0 || c>0) && maze[r][c] == 1) {
            return 0;
        }

        if(r == 0 && c == 0 && maze[r][c] != 1) {
            return 1;
        }

        if(dp[r][c] != -1) return dp[r][c];


        int down = pathCount(maze, r - 1, c, dp);

        int right = pathCount(maze, r, c - 1, dp);

        dp[r][c] = down + right;
        return dp[r][c];
    
    }
}