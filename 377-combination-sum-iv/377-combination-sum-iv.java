class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dynamic programming array - dp[i] will contain the number of combination start from current sum i
        int[] dp = new int[target+1];
        dp[target] = 1; // initialize the last cell
        for (int i = target; i >= 0; i--){
            for (int x : nums){ // for each value in the array, add the value in the array of dp[i+x] (increment the sum)
                dp[i] += (i + x > target ? 0 : dp[i+x]);
            }
        }
        return dp[0]; // return the result starting from sum = 0
    }
}