class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int[] dp = new int[n+1];
        
        helper(cost, 0, dp);
        return Math.min(dp[0], dp[1]);
    }
    
    private int helper(int[] cost, int i, int[] dp) {
        if( i == cost.length || i == cost.length + 1) {
            return 0;
        }
        
        if(dp[i] != 0) {
            return dp[i];
        }
        
        int t1 = helper(cost, i+1, dp);
        int t2 = helper(cost, i+2, dp);
        
        dp[i] = Math.min(t1, t2) + cost[i];
        
        return dp[i];
    }
}