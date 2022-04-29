class Solution {
    public boolean isBipartite(int[][] graph) {
        isBiparate = true;
        int[] used = new int[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if(used[i] == 0) {
                dfs(i, 1, used, graph);
            }
        }
        
        return isBiparate;
    }
    
    boolean isBiparate;
    
    void dfs(int u, int col, int[] used, int[][] graph) {
        used[u] = col;
        for (int i = 0; i < graph[u].length; ++i) {
            if (used[graph[u][i]] == 0) {
                dfs(graph[u][i], 3 - col, used, graph);
            } else if (used[graph[u][i]] == used[u]) {
                isBiparate = false;
            }
        }
    }
}