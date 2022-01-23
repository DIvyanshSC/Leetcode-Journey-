class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // this makes sure that the repeated elements are stored together in a sorted order, so we can skip them

        helper(0, candidates, ans, target, new ArrayList<>());
        return ans;
    }

    private void helper(int idx, int[] arr, List<List<Integer>> ans, int target, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        // // REMEMBER THIS - this is a pattern
        // this loop keeps moving till arr end is reached, starting at current
        for(int i = idx; i < arr.length; i++) {

            if(i > idx && arr[i] == arr[i-1]) {
                continue; // we continue until we find the next unique element
            }

            if(arr[i] > target) { // an optimsation, we break as soon as we see that element is getting bigger than our remaining target
                break; // hence we dont require those extra further recursion calls
            }

            // now are base cases has been handled above so we move to our main solution
            int num = arr[i];
            ds.add(num);

            helper(i+1, arr, ans, target - num, ds);
            // when we backtrack, we remove the element
            ds.remove(ds.size() - 1);
        }

    }
}