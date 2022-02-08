class Solution {
    // same approach as house robber 1, just we take max of values taken by using last & using first(separately)
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        
        // contains everything apart from 1st element
        ArrayList<Integer> temp1 = new ArrayList<>();

        // contains everything apart from last element
        ArrayList<Integer> temp2 = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(i != 0) temp1.add(nums[i]);
            if(i != n-1) temp2.add(nums[i]);
        }

        int ans_using_first = f(temp1);
        int ans_using_last = f(temp2);

        int final_result = Math.max(ans_using_first, ans_using_last);
        return final_result;
    }

    private static int f(ArrayList<Integer> nums) {
        int n = nums.size();

        int curr = 0;
        int prev = nums.get(0);
        int prev2 = 0;

        for(int i = 1; i < n; i++) {
            int take = nums.get(i) + prev2;
            int notTake = prev;

            curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}