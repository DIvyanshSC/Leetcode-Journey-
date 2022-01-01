class Solution {
    public int arraySign(int[] nums) {
        
        int neg = 0;
        for(int i : nums) {
            if(i == 0) {
                return 0;
            }
            
            if(i < 0) {
                neg++;
            }
        }
        
        return neg % 2 == 0 ? 1 : -1;
    }
}