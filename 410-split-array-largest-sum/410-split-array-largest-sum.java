class Solution {
    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = nums.length;

        for(int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop this will contain the max of nums array
            end += nums[i];
        }

        //binary search
        while(start < end) {
            int mid = start + (end - start) / 2;
            // making subarrays
            int sum = 0;
            int pieces = 1;

            for(int num : nums) {
                if(sum + num > mid) {
                    // cannot add in this subarray so we create new one
                    sum = num;
                    pieces++;
                }

                else {
                    sum += num;
                }
            }

            if(pieces > m) {
                start = mid + 1;
            }

            else {
                end = mid;
            }
        }

        return start; // can return end also as start == end
    }
}