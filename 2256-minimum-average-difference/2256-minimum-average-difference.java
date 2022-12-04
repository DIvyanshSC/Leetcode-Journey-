class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        long[] arr = new long[n];
        arr[0] = nums[0];
        int min = (int)1e8;
        
        
        for(int i = 1; i < n; i++) {
            arr[i] = nums[i] + arr[i-1];
        }
        
        int ind = 0;
        for(int i = 0; i < n; i++) {
            
            long c1 = arr[i];
            long c2 = arr[n-1] - c1;
            
            long a1 = c1 / (i+1);
            long a2 = 0;
            
            if(i == n-1) {
                a2 = 0;
            }
            
            else a2 = c2 / (n-i-1);
            
            if(min > Math.abs(a1-a2)) {
                
                min = (int) Math.abs(a1-a2);
                ind = i;
            }
        }
        
        return ind;
    }
}