class Solution {
    public int countSubstrings(String s) {
        // TC = O(N^2), SC = O(N^2)
        int n = s.length(), palindromeCount = 0;
        boolean[][] dp = new boolean[n][n];
        
        
        // gap - represents diagonal where start < end
        // gap - ranges from 0 to string length - 1
        for(int gap=0 ; gap<=n-1 ; gap++){
            
            // i - row, j - column
            // diagonal starts from first row and end at last column 
            for(int i=0,j=gap ; j<n ; i++,j++){
                
                // diagonal 0 will always be true because there is only one character
                if(gap == 0){
                    dp[i][j] = true;
                }
                
                // diagonal 1 will contain 2 characters only
                // if both characters are equal then put dp[i][j] = true else put false
                else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                
                // for remaining diagonals
                // check first and last characters and check dp[i+1][j-1] == true then put true at dp[i][j] 
                // else put false at dp[i][j]
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j]){
                    palindromeCount++;
                }
            }
        }
        return palindromeCount;
    }
}