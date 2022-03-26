class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(nums[m] > target) {
                e = m-1;
            }
            
            else if(nums[m] < target) {
                s = m+1;
            }
            
            else return m;
        }
        return -1;
    }
}