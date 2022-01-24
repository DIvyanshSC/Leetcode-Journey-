class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean [][] pacific = new boolean[row][col];
        boolean [][] atlantic = new boolean[row][col];

        for(int i = 0;i<row;i++){
            findans(heights,pacific,Integer.MIN_VALUE,i,0,row,col);
            findans(heights,atlantic,Integer.MIN_VALUE,i,col - 1,row,col);
        }
        for(int i = 0;i<col;i++){
            findans(heights,pacific,Integer.MIN_VALUE,0,i,row,col);
            findans(heights,atlantic,Integer.MIN_VALUE,row - 1,i,row,col);
        }

        List<List<Integer>> outer = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(pacific[i][j] && atlantic[i][j]) {

                    List<Integer> inner = new ArrayList<>();
                    inner.add(i);inner.add(j);
                    outer.add(new ArrayList<>(inner));
                }
            }
        }

        return outer;
    }

    static int [][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    private static void findans(int[][] matrix,boolean[][] visited, int prevheight, int r, int c, int rows, int cols) {

        if(
                r < 0 ||
                r >= rows ||
                c < 0 ||
                c>= cols ||
                visited[r][c] ||
                prevheight > matrix[r][c]
        ) {
            return;
        }

        visited[r][c] = true;
        for(int[] d : dir) {
            findans(matrix,visited,matrix[r][c],r + d[0],c + d[1],rows,cols);
        }
    }
}