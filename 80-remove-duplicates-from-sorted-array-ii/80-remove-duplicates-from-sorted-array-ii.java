class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0;
        
        int currNum = nums[0];
        int currCount = 1;
        
        for(int i = 1; i < n; i++) {
            
           if(nums[i] == currNum && currCount < 2) {
               
               k++;
               nums[k] = nums[i];
               currCount = 2;
           }
            
           else if(nums[i] != currNum) {
               
               currNum = nums[i];
               currCount = 1;
               k++;
               nums[k] = nums[i];
           }       
        }
        return k+1;
    }
}