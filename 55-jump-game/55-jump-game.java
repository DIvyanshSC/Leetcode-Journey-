class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums, 0, new Boolean[nums.length + 1]);
    }
    
    private boolean canJump(int[] nums, int index, Boolean[] dp) {
        if(index == nums.length - 1) {
            return true;
        }
        
        if(dp[index] != null) {
            return dp[index];
        }
        
        int n = nums[index];
        for(int i = n; i > 0; i--) {
            if(index + i < nums.length && canJump(nums, index + i, dp)){
                dp[index] = true;
                return true;
            }
        }
        
        dp[index] = false;
        return false;
    }
}