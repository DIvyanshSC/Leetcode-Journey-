class Solution {
    public int numDistinct(String s, String t) {
        String s1 = s, s2 = t;
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

//        int ans = f(n, m, s1, s2, dp);
//        return ans;

        for(int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        // int res = tabulated(s1, s2, dp);
        // System.out.println();
        return spaceOptimised(s1, s2);
    }

    private static int spaceOptimised(String s1, String s2) {
        // TC: O(n*m) ; SC: O(m)

        int n = s1.length(), m = s2.length();
        int[] prev = new int[m+1];

        // base case
        for(int j = 0; j <= m; j++) {
            if(j == 0) prev[j] = 1;

            else prev[j] = 0;
        }

        // recursive case
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            curr[0] = 1; // for every curr, if we have exhausted the s2, we got a potential answer hence we keep 0th value of every curr as 0(we immitating 2d dp table
            for(int j = 1; j <= m; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    int take = prev[j-1]; // taking that value and checking for rest of matching of s2 in s1

                    int notTake = prev[j]; // not taking hence jth char(s2) remains the same & we try to match jth char(s2) in remaining part of s1

                    curr[j] = take + notTake;

                }

                // not match case - we cannot take value in s1 as they are not matching
                else {
                    curr[j] = prev[j]; // we try to find jth char of s2 in remaining part of s1
                }
            }

            // System.out.println(Arrays.toString(prev));
            prev = curr;
        }
        // System.out.println(Arrays.toString(prev));
        return prev[m];
    }

    private static int tabulated(String s1, String s2, int[][] dp) {
        // TC: O(n*m) ; SC: O(n*m)

        int n = s1.length(), m = s2.length();
        // base case
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1; // we exhausted all values in s2
        }

        for(int j = 1; j <= m; j++) { // starting from 1 b/c it would override the condition from previous for loop
            dp[0][j] = 0; // we exhausted all values in s1 but values in s2 are still left to be matched
        }


        // recursive case
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    int take = dp[i-1][j-1]; // taking that value and checking for rest of matching of s2 in s1

                    int notTake = dp[i-1][j]; // not taking hence jth char(s2) remains the same & we try to match jth char(s2) in remaining part of s1

                    dp[i][j] = take + notTake;

                }

                // not match case - we cannot take value in s1 as they are not matching
                else {
                    dp[i][j] = dp[i-1][j]; // we try to find jth char of s2 in remaining part of s1
                }
            }
        }

        for(int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[n][m];
    }

    private static int f(int i, int j, String s1, String s2, int[][] dp) {
        // TC: O(n*m) ; SC: O(n*m) + ASS

        /**
         * SHIFTING - base case -> i < 0 && j < 0 becomes i == 0 && j == 0
         * matching case in string stays 0 based but all other things are being considered as 1 based
         */

        // base case
        if( j == 0) return 1; // all matching is done and s2 is exhausted
        if(i == 0) return 0; // still some matching needs to be done and s2 is not exhausted but s1 is exhausted

        if(dp[i][j] != -1) return dp[i][j];

        // recursive case

        // matching case - we try to take & not take the curr value from s1 which is matching s2
        if(s1.charAt(i-1) == s2.charAt(j-1)) {

            int take = f(i-1, j-1, s1, s2, dp); // taking that value and checking for rest of matching of s2 in s1

            int notTake = f(i-1, j, s1, s2, dp); // not taking hence jth char(s2) remains the same & we try to match jth char(s2) in remaining part of s1

            dp[i][j] = take + notTake;

        }

        // not match case - we cannot take value in s1 as they are not matching
        else {
            dp[i][j] = f(i-1, j, s1, s2, dp); // we try to find jth char of s2 in remaining part of s1
        }

        return dp[i][j];
    }
}