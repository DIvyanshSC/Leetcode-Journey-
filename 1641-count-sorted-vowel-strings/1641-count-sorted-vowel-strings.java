class Solution {
    public int countVowelStrings(int n) {
        /**
            TC: O(n)
            SC: O(1) ~ 5 size array used
        */
        
        int dp[] = new int[5];
        Arrays.fill(dp, 1);

        
        for(int i=0; i<n-1; i++){
            int sum = 0;
            for(int j=0; j<5; j++){
                sum += dp[j];
            }

            for(int j=0; j<5; j++){
                int temp = sum - dp[j];
                dp[j] = sum;
                sum = temp;
            }
        }

        int sum = 0;
        for(int i=0; i<dp.length; i++){
            sum += dp[i];
        }

        return sum;
    }
}