class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>> result = new ArrayList();
        
        int rows = grid.length;
        int col = grid[0].length;

        for (int r = 0; r < rows; r++) { // filling all the rows of result with empty lists
            result.add(new ArrayList());
        }
        k %= (rows * col); // every rows*col shifts grid became the same, skipping the similar shifts
        
        int dimension = rows * col;
        
        // element at (begin) will be at 0,0 in new grid
        int begin = dimension - k;
        
        int x = 0; // counter variable

        for (int i = begin; i < begin + dimension; i++) {
            
            int r = (i / col) % rows;
            int c = i % col; // calculating row and cell for new grid
            result.get(x / col).add(grid[r][c]); // adding new element in new row
            x++;
        }
        return result; // returning result list
    }
}