class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        int lcs_count = tabulated(s1, s2, dp);

        String SCS = printSCSwithDP(s1, s2, n, m, dp);
        

        return SCS;
    }

    private static String printSCSwithDP(String t1, String t2, int n, int m, int[][] dp) {
        // TC: O(n+m) ; SC: O(n*m)

        if (t1 == null || t2 == null || t1.length() == 0 || t2.length() == 0) return null;

        int i = n, j = m;
        StringBuilder res = new StringBuilder();

        while(i > 0 && j > 0) {

            // match - we add answer once
            if(t1.charAt(i-1) == t2.charAt(j-1)) {
                res.append(t1.charAt(i-1));
                i--;
                j--;
            }

            // not match - we add directly
            else if(dp[i-1][j] > dp[i][j-1]) {
                res.append(t1.charAt(i-1));
                i = i-1;
            }
            // dp[i-1][j] < dp[i][j-1]
            else {
                res.append(t2.charAt(j-1));
                j = j-1;
            }
        }
        
        // EDGE CASES - at the end of while loop above, 
        // their might be values left in either strings(i,j) -> (0,1) or (1,0)
        // hence we add those remaining chars in result
        while(i > 0) {
            res.append(t1.charAt(i-1));
            i--;
        }

        while(j > 0) {
            res.append(t2.charAt(j-1));
            j--;
        }


        return res.reverse().toString();

    }

    private static int tabulated(String t1, String t2, int[][] dp) {
        // TC: O(n*m); SC: O(n*m)

        if (t1 == null || t2 == null || t1.length() == 0 || t2.length() == 0) return 0;

        // for tabulation, we observe that in memoization, we had -1 index as base case,
        // now since -1 cannot be represented in dp array, we perform shifting of indexes

        // SHIFTING: we treat every index as a -1'th for it
        // ex: n is treated as n-1, m as m-1, 1 as 0, 0 as -1
        // by doing this, we eliminated the condition where -1 would occur(is replaced by 0)

        int n = t1.length(), m = t2.length();

        // base case
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }

        // Recursive case
        // dp[i][j]: longest subsequence in first i in text1 & first j in text2
        // every i is treated as i-1 & every j is treated as j-1
        for (int i = 1; i <= n; ++i) {

            for (int j = 1; j <= m; ++j) {

                if (t1.charAt(i - 1) == t2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                }

                else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                }
            }
        }
        // for(int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }

        return dp[n][m];
    }
}