class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans[len - 1]) {
                ans[len] = nums[i];
                len++;
            } else {
                int idx = binarySearch(ans, len - 1, nums[i]);
                ans[idx] = nums[i];
            }
        }
        return len;
    }
    public int binarySearch(int[] ans, int hi, int item) {
        int lo = 0;
        int mid;
        int idx = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (ans[mid] >= item) {
                idx = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return idx;
    }
}