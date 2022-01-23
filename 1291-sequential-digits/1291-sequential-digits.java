class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1; i<=9; i++) {
            dfs(low, high, i, 0, arr);
        }
        
        arr.sort((a,b) -> a - b);
        return arr;
    }
    
    void dfs(int low, int high, int i, int num, ArrayList<Integer> ans) {
        
        if (num >= low && num <= high) {
            ans.add(num);
        }
        // case 2: [1000, 13000] if i=10 and num is 6789, then we should stop
        if (num > high || i > 9) { 
            return;
        }
        dfs(low, high, i+1, num*10 + i, ans);
    }
}