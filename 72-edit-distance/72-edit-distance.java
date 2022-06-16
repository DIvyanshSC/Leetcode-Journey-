class Solution {
    /**
     * APPROACH - In all string matching algorithms, we try to match the characters at indexes
     *            then, depending on the situation, we either sum our all case or take max or min
     *            we can have multiple operations inside match case as well as multiple operations inside not match case
     *            generally, inside match case 1 operation is present and inside not match case multiple operations are present
     *
     *            OPERATION - a int case where we do recursive call or check from previous values in DP
     *            In this qn : inside not match we have 3 operations - insert/delete/replace
     *            we need to think it in a way that if we do these operations then how will it effect my strings
     */

    /**
     * f(i,j) -> minimum steps to convert s1[0...i] to s2[0...j]
     */
    public int minDistance(String word1, String word2) {

        /** answer lies between 0(both strings are same) & s1 + s2(removing all elements of s1 & then adding elements of s2)*/

        String s1 = word1, s2 = word2;
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

//        return f(n,m,s1,s2,dp);
        dp = new int[n+1][m+1];
        // int ans = tabulated(s1, s2, dp);
//        return ans;
        // System.out.println();

        return spaceOptimised(s1, s2);
    }

    private static int spaceOptimised(String s1, String s2) {
        // TC: O(n*m) ; SC: (m)
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m+1];

        // base case
        for(int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        // recursive case
        for(int i = 1; i <= n; i++) {

            int[] curr = new int[m+1];
            curr[0] = i; // 2nd base case, first element of every row should be the no. of row as seen in 2d dp table

            for(int j = 1; j <= m; j++) {

                // matching
                if(s1.charAt(i-1) == s2.charAt(j-1)) {

                    // already matching hence we donot need to add to the steps and we go to next(actually previous) character in both s1 & s2
                    curr[j] = prev[j-1];
                }

                // not matching
                else {
                    int insert = 1 + curr[j-1]; // we add element at j+1th index to s1 so it matches with j and keep ith same & move j until j matches with i in next iterations

                    int delete = 1 + prev[j]; // only i is reduced as we deleted ith element but we keep j as it is until we find j matching with i

                    int replace = 1 + prev[j-1]; // we replace element at i to jth element hence we got a matching, so both indexes go to next(previous actually)

                    // taking minimum of all 3
                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }

            // System.out.println(Arrays.toString(prev));
            prev = curr;
        }

        // System.out.println(Arrays.toString(prev));

        return prev[m];
    }

    private static int tabulated(String s1, String s2, int[][] dp) {
        // TC: O(n*m) ; SC: (n*m)
        int n = s1.length(), m = s2.length();
        // base case
        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // recursive case
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                // matching
                if(s1.charAt(i-1) == s2.charAt(j-1)) {

                    // already matching hence we donot need to add to the steps and we go to next(actually previous) character in both s1 & s2
                    dp[i][j] = dp[i-1][j-1];
                }

                // not matching
                else {
                    int insert = 1 + dp[i][j-1]; // we add element at j+1th index to s1 so it matches with j and keep ith same & move j until j matches with i in next iterations

                    int delete = 1 + dp[i-1][j]; // only i is reduced as we deleted ith element but we keep j as it is until we find j matching with i

                    int replace = 1 + dp[i-1][j-1]; // we replace element at i to jth element hence we got a matching, so both indexes go to next(previous actually)

                    // taking minimum of all 3
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        // for(int[] arr : dp) {
        //     System.out.println(Arrays.toString(arr));
        // }
        return dp[n][m];
    }

    private static int f(int i, int j, String s1, String s2, int[][] dp) {
        // TC: O(n*m) ; SC: (n*m) + ASS

        // base case
        if(i == 0) return j; // s1 is exhausted hence we need to do insert operations to add remaining elements of s2 in s1
        if(j == 0) return i; // s2 is exhausted hence we need to do delete operations to remove remaining elements of s1

        if(dp[i][j] != -1) return dp[i][j];

        // recursive case

        // matching
        if(s1.charAt(i-1) == s2.charAt(j-1)) {

            // already matching hence we donot need to add to the steps and we go to next(actually previous) character in both s1 & s2
            dp[i][j] = f(i-1, j-1, s1, s2, dp);
        }

        // not matching
        else {
            int insert = 1 + f(i, j-1, s1, s2, dp); // we add element at j+1th index to s1 so it matches with j and keep ith same & move j until j matches with i in next iterations

            int delete = 1 + f(i-1, j, s1, s2, dp); // only i is reduced as we deleted ith element but we keep j as it is until we find j matching with i

            int replace = 1 + f(i-1, j-1, s1, s2, dp); // we replace element at i to jth element hence we got a matching, so both indexes go to next(previous actually)

            // taking minimum of all 3
            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j];
    }
}