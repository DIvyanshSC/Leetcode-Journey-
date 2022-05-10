class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // corner cases
        if (k <= 0 || n <= 0 || k > n) {
            return ans;
        }

        // The upper bound of n: [9, 8, ... , (9 - k + 1)], sum is (19 - k) * k / 2
        if (n > (19 - k) * k / 2) {
            return ans;
        }

        backtrack(ans, new ArrayList<>(), 1, k, n);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> path, int start, int k, int target) {
        if (k < 0 || target < 0) {
            return;
        }

        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            // trim 
            if (i > target) {
                break;
            }
			
            // trim
            if (target - i == 0 && k > 1) {
                break;
            }

            path.add(i);
            backtrack(res, path, i + 1, k - 1, target - i);
            path.remove(path.size() - 1);
        }
    }
}