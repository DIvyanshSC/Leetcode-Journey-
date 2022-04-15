class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        StringBuilder temp = new StringBuilder(s);

        String s2 = temp.reverse().toString();

        // This works because palindrome means reverse of string is also present or not
        // and LCS checks what is common between 2 strings,
        // hence the common part btw s and reverse of s will be the palindromic subsequence

        return space_optimised(s1, s2);
    }

    /**
     * Exact same code for LCS, just in place of 2 different strings,
     * I am passing string1 as 1st string and reverese of string1 as 2nd string
     */
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