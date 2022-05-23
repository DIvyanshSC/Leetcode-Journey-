class Solution {
    public int findMaxForm(String[] strs, int zeroes, int ones) {
        
        // STATE SPACE OPTIMISED
        int size = strs.length;
        int[][][] dp = new int[size + 1][zeroes + 1][ones + 1];
        int[][] prev = new int[zeroes + 1][ones + 1];

        for(int index = 0; index <= size; index++){
            
            for(int m = zeroes; m >= 0; m--){
                for(int n = ones; n >= 0; n--){
                    //BASE CASE
                    if(index == 0) {
                        // dp[index][m][n] = 0;
                        prev[m][n] = 0;
                        continue;
                    }

                    //Not Adding
                    // int dontAdd = dp[index - 1][m][n]; 
                    int dontAdd = prev[m][n]; 


                    //Adding
                    int[] count = getCount(strs[index - 1]);
                    int add = 0;
                    if (count[0] <= m && count[1] <= n) 
                        // add = 1 + dp[index - 1][m - count[0]][n - count[1]];
                        add = 1 + prev[m - count[0]][n - count[1]];


                    // dp[index][m][n] = Math.max(dontAdd, add);
                    prev[m][n] = Math.max(dontAdd, add);

                }
            }
        }
        
        // return dp[size][zeroes][ones];
        return prev[zeroes][ones];

        
        /**
            int[][] dp = new int[M+1][N+1];
            for (String str : S) {
                int zeros = 0, ones = 0;
                for (char c : str.toCharArray())
                    if (c == '0') zeros++;
                    else ones++;
                for (int i = M; i >= zeros; i--)
                    for (int j = N; j >= ones; j--)
                        dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
            }
            return dp[M][N];
        
        */
        
    }
    
    private int[] getCount(String str){
       
       int ones = 0, zeroes = 0;
       for(char c : str.toCharArray()){
           if(c == '0') zeroes++;
           else if(c == '1') ones++;
       }
       
       int[] count = new int[]{zeroes, ones};
       return count;
   }
}