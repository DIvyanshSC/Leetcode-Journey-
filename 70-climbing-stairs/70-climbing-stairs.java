class Solution {
    public int climbStairs(int n) {
        return helper(n, new int[n+1]);
    }
    
    private int helper(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return 1;
        }
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
        
//         if(n == 1 || n == 2) {
//             return n;
//         }
        
//         dp[1] = 1;
//         dp[2] = 2;
        
//         for(int i = 3; i <= n; i++) {
//             dp[i] = dp[i-1] + dp[i-2];
//         }
        
//         return dp[n];
    }
}