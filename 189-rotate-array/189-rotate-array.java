class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; 
        
        if(k < 0) { // for -ve value of k, useful for interview
            k += nums.length;
        }
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int i, int j){
        int li = i;
        int ri = j;
        
        while(li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;
            
            li++;
            ri--;
        }
    }
}