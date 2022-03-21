class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        int ans = f(coins.length-1, amount, coins, dp);
        return ans == (int)1e9 ? -1 : ans;
    }

    private static int f(int ind, int T, int[] coins,int[][] dp) {
        //base case
        if(ind == 0) {
            if(T % coins[ind] == 0) {
                return T/coins[ind];
            }

            return (int)1e9;
        }

        if(dp[ind][T] != -1) return dp[ind][T];

        //recursive calls
        int notTake = f(ind-1, T, coins, dp);

        int take = Integer.MAX_VALUE;
        if(coins[ind] <= T) {
            take = 1 + f(ind, T - coins[ind], coins, dp);
        }

        dp[ind][T] = Math.min(take, notTake);
        return dp[ind][T];
    }
}