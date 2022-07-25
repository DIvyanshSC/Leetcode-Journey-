class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1, -1};
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);
        
        return ans;
    }
    
    private int search(int[] nums, int target, boolean firstIndex) {
        int s = 0;
        int e = nums.length - 1;
        
        int ans = -1;
        while(s <= e) {
            int m = (s+e)/2;
            
            if(nums[m] < target) {
                s = m + 1;
                
            }
            
            else if(nums[m] > target) {
                e = m - 1;
            }
            
            else {
                ans = m;
                if(firstIndex) {
                    e = m - 1;
                }
                else {
                    s = m + 1;
                }
            }
         }
        return ans;
    }
}