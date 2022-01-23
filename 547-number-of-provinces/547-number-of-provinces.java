class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int row = isConnected.length;
        int col = isConnected[0].length;
        int num = 0;

        int[] visited = new int[row];
        Arrays.fill(visited,0);

        for(int i = 0; i < row; i++) {
            if(visited[i] == 0) {
                num++;
                dfs(isConnected, visited, i);
            }
        }
        return num;
    }
    
    private void dfs(int[][] isConnected, int[] visited, int i) {
        visited[i] = 1;
        for(int j = 0; j < isConnected.length; j++) {
            if(visited[j] == 0 && isConnected[i][j] == 1) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}