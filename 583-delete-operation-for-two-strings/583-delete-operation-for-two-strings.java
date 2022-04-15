class Solution {
    public int minDistance(String word1, String word2) {
        
        // elements to be deleted = uncommon element in string1 + uncommon element in string2
        // this would leave the common part in both strings
        // common part is nothing but longest common subsequence
        int lcs = space_optimised(word1, word2);
        int ans = (word1.length() - lcs) + (word2.length() - lcs);
        return ans;
    }
    
    private static int space_optimised(String t1, String t2) {
        // TC: O(n*m); SC: O(m)
        if (t1 == null || t2 == null || t1.length() == 0 || t2.length() == 0) return 0;

        int n = t1.length(), m = t2.length();
        int[] prev = new int[m+1];

        // base case
        for(int j = 0; j <= m; j++){
            prev[j] = 0;
        }

        // recursive case
        for(int i = 1; i <= n; i++) {

            int[] curr = new int[m+1];
            for(int j = 1; j <= m; j++) {

                if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                }

                else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}