class Solution {
    public List<List<Integer>> generate(int numRows) {
        return recursionSubset(numRows);
    }
    
    public List<List<Integer>> recursionSubset(int n) {
        List<List<Integer>> outer = new ArrayList<>(n);
        
        for(int i = 0; i < n; i++) {
            List<Integer> internal = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0) {
                    internal.add(1);
                }
                
                else {
                    List<Integer> temp = outer.get(i - 1);
                    internal.add(temp.get(j - 1) + temp.get(j));
                }
            }
            
            outer.add(internal);
        }
        return outer;
    }
}