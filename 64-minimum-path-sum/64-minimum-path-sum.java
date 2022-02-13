class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return tabulated(n-1, m-1, grid);
        

    }

    private static int tabulated(int row, int col, int[][] grid) {
        // Space Optimised
        int[] prev = new int[col+1];
        Arrays.fill(prev, -1);

        for(int r = 0; r <= row; r++) {
            int[] temp = new int[col+1];
            for(int c = 0; c <= col; c++) {

                if(r == 0 && c == 0) {
                    temp[c] = grid[r][c];
                }

                else {

                    int right = grid[r][c];
                    int down = grid[r][c];

                    if (c > 0) right += temp[c - 1];
                    else right += (int)Math.pow(10, 9);

                    if (r > 0) down += prev[c];
                    else down += (int)Math.pow(10, 9);

//                    dp[r][c] = Math.min(right, down);
                    temp[c] = Math.min(right, down);
                }

            }
            prev = temp;
        }

        return prev[col];
    }
}