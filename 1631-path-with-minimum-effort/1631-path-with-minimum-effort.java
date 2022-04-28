class Solution {
    public int minimumEffortPath(int[][] heights) {
        // view each cell as a node, effort is the weight between two nodes
        // problem => SSSP, use dijkstra's
        
        // usually, need a map for graph, this problem, lemme think... no need, since we know neighbors
        // node using row-majored index
        
        // for dijkstra's
        // Set<Integer> settled, PriorityQueue<(node, dist)> ascending by dist
        int n = heights.length;
        int m = heights[0].length;
        
        if(n == 1 && m == 1){
            return 0;
        }
        
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int dst = n * m - 1;
        Set<Integer> settled = new HashSet<>();
        //{node, effortFromSrc}
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> (n1[1] - n2[1])); 
        // int[] dist = new int[n * m];
        
        // Arrays.fill(dist, Integer.MAX_VALUE);
        // dist[0] = 0;
        
        pq.offer(new int[]{0, 0});
        int ans = 0;
        while(!pq.isEmpty()){
            int u = pq.peek()[0];
            int cost = pq.poll()[1];
            
            if(settled.contains(u)) continue;
            
            settled.add(u);
            ans = Math.max(ans, cost);
            
            if(u == dst){
                return ans;
            }
            
            int x = u / m;
            int y = u % m;
            // get neighbors (valid and not settled)
            for(int[] direction : directions){
                int nx = x + direction[0];
                int ny = y + direction[1];
                int v = nx * m + ny;
                
                if(!isValid(nx, ny, n, m)) continue;
                if(settled.contains(v)) continue;
                
                // relax
                int w = Math.abs(heights[nx][ny] - heights[x][y]);
                // if(w < dist[v]){
                // dist[v] = w;
                pq.offer(new int[]{v, w});
                // }
            }
        }
        
        return ans;
    }
    
    
    private boolean isValid(int x, int y, int n, int m){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}