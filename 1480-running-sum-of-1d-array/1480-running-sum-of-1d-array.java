class Solution {
    public int[] runningSum(int[] nums) {
        long maxYet = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            maxYet += nums[i];
            nums[i] = (int)maxYet;
        }
        
        return nums;
    }
}