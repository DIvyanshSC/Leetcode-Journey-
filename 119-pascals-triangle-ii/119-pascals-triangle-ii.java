class Solution {
    public List<Integer> getRow(int rowIndex) {
        int n = rowIndex;
        long c = 1;
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        
        for (int i = 0; i < n; i++) {
            c *= n-i;
            c /= i+1;
            res.add((int)c);
            
           //  res.add((int)val);
           // val = val*(n - i)/(i + 1);
        }
        
        System.out.println(res);
        
        return res;
    }
}