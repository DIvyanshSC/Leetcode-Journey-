class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0; 
        int e = numbers.length - 1;
        int[] ans = {-1, -1};
        if(e <= 0 || numbers == null) {
            return ans;
        } 
        while(s < e) {
            long sum = numbers[s] + numbers[e];
            if(sum > target) e--;
            
            else if(sum < target) s++;
            
            else {
                ans[0] = s+1;
                ans[1] = e+1;
                break;
            }
        }
        
        return ans;
    }
}