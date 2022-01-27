class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return dp(nums, n-1);
    }
    
    public HashMap<Integer, Integer> map = new HashMap();
    private int dp(int[] nums, int i) {
        if(i == 0) {
            return nums[0];
        }
        
        if(i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        
        if(!map.containsKey(i)) {
            map.put(i, Math.max(dp(nums, i-1), nums[i] + dp(nums, i-2)));
        }
        
        return map.get(i);
    }
    
}