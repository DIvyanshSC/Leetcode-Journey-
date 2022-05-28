class Solution {
    public int missingNumber(int[] nums) {
        int count = 0;
        int totalSum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            count += i+1;
            totalSum += nums[i];
        }
        
        int ans = count - totalSum;
        return ans;
    }
}