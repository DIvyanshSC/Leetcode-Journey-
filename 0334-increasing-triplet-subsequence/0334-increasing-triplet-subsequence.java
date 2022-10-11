class Solution {
    public boolean increasingTriplet(int[] nums) {
        int var1 = Integer.MAX_VALUE;
        int var2 = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= var1)
                var1 = nums[i];
            else if (nums[i] <= var2)
                var2 = nums[i];
            else return true;
        }
        return false;
    }
}