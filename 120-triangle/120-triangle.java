class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        
        
        // return f(0, 0, triangle, dp);
        return tabulated(0, 0, triangle);
    }
    
    private static int tabulated(int row, int col, List<List<Integer>> grid) {
        // tabulation is always opposite to recursive memoization, hence here we go from n-1 to 0
        
        int n = grid.size();
        int[] prev = new int[n];
        for(int j = 0; j < n ; j++){
            prev[j] = grid.get(n-1).get(j);
        }
        
        
        for(int r = n-2; r >= 0; r--) { // for each row
            int[] temp = new int[r+1];
            for(int c = r; c >= 0; c--) { // for each column
                int down = grid.get(r).get(c) + prev[c];
                int dia = grid.get(r).get(c) + prev[c+1];

                temp[c] = Math.min(down, dia);
            }
            prev = temp;
        }
        
        
        return prev[col];
    }
    
        private static int f(int row, int col, List<List<Integer>> grid, int[][] dp) {
        // here we are not going top down in memoisation because top is variable & we prefer fixed answer as our starting point, so start is fixed hence we go from bottom to up

        // base case: base case is generally the condition where our recursive call would terminate
        if (row == grid.size() - 1) {
            return grid.get(row).get(col);
        }

        if (dp[row][col] != -1) return dp[row][col];

        int down = grid.get(row).get(col) + f(row + 1, col, grid, dp);
        int dia = grid.get(row).get(col) + f(row + 1, col + 1, grid, dp);


        dp[row][col] = Math.min(down, dia);
        return dp[row][col];
    }   
}