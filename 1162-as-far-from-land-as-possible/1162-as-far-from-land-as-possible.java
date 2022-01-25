class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];

        boolean ones = false, zeros = false;

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    dist[i][j] = Integer.MAX_VALUE;
                    zeros = true;
                }

                else {
                    dist[i][j] = -1;
                    deque.addLast(new int[]{i, j, 0});
                    ones = true;
                }
            }
        }

        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (!zeros || !ones) {
            return -1;
        }
        int res = -1;
        while (!deque.isEmpty()) {

            int[] pre = deque.pollFirst();

            for (int[] step : steps) {

                int x = pre[0] + step[0];
                int y = pre[1] + step[1];
                int newStep = pre[2] + 1;
                if (
                        x < 0 ||
                        x >= m ||
                        y < 0 ||
                        y >= n ||
                        dist[x][y] == -1 ||
                        newStep >= dist[x][y]
                ) {
                    continue;
                }

                dist[x][y] = newStep;
                res = Math.max(res, newStep);
                deque.addLast(new int[]{x, y, newStep});

            }
        }

        return res;
    }
}