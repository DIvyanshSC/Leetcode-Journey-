class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, new ArrayList<>(), target, res);
        return res;
    }
    
    private void helper(int i, int[] arr, ArrayList<Integer> ans, int x, List<List<Integer>> res) {
        if(i == arr.length) {
            if(x == 0) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        int num = arr[i];

        if(num <= x) {
            ans.add(num);

            helper(i, arr, ans, x - num, res);
            ans.remove(ans.size() - 1);
        }

        helper(i+1, arr, ans, x, res);

    }
}