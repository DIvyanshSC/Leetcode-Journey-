class Solution {
    public int getMoneyAmount(int n) {
        if (n <= 1) {
            return 0;
        }

        return helper(0, n, new int[n+1][n+1]);
    }

    private static int helper(int left, int right, int[][] dp) {

        if (left >= right) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }
        int minCost = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {

            int cost = i + Math.max(helper(left, i-1, dp), helper(i+1, right, dp));
            minCost = Math.min(minCost, cost);
        }

        dp[left][right] = minCost;
        return minCost;
    }
}