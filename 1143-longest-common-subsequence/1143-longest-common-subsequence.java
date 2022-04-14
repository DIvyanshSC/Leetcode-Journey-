class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        if (t1 == null || t2 == null || t1.length() == 0 || t2.length() == 0) return 0;

        int n = t1.length(), m = t2.length();
        int[] prev = new int[m+1];

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