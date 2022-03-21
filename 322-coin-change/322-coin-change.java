class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = space_optimised(coins, amount, coins.length);
        return ans == (int)1e9 ? -1 : ans;
    }

    private static int space_optimised(int[] coins, int T, int n) {
        // TC: O(n*T) ; SC: O(T)

        //array 1D creation
        int[] prev = new int[T+1];

        //base case
        for(int t = 0; t <= T; t++) {
            if(t % coins[0] == 0) {
                prev[t] = t/coins[0];
            }

            else prev[t] = (int)1e9;
        }

        //recursive case
        for(int i = 1; i < n; i++) {
            int[] curr = new int[T+1];
            for(int t = 0; t <= T; t++) {
                int notTake = prev[t];
                int take = Integer.MAX_VALUE;

                if(coins[i] <= t) {
                    take = 1 + curr[t-coins[i]];
                }

                curr[t] = Math.min(take, notTake);
            }
            prev = curr;
        }

        return prev[T];
    }
}