class Solution {
    private int[][] Directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int row = matrix.length, col= matrix[0].length, longestPath = 0;
        int[][] cache = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int longest = dfs(matrix,cache,row,col,i,j);
                longestPath= Math.max(longestPath,longest);
            }
        }
        return longestPath;
    }
    
    private int dfs(int[][] matrix, int[][] cache, int row, int col, int currX,int currY){
        if(cache[currX][currY] > 0) return cache[currX][currY];
        
        int max = 0;
        
        for(int[] direction: Directions){
            int nextX = currX + direction[0], nextY = currY + direction[1];
            
            if(nextX > -1 && nextX < row && nextY > -1 && nextY < col && matrix[nextX][nextY] > matrix[currX][currY]){
                int longest = dfs(matrix,cache,row,col,nextX,nextY);
                max=Math.max(max,longest);
            }
        }
        cache[currX][currY] = max + 1; //Adding 1 for current cell
        return cache[currX][currY];
    }
}