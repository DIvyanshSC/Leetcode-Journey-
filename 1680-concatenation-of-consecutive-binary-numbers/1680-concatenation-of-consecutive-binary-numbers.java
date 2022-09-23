class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long bin = 0;
        int len = 0;

        for (int i = 1; i <= n; i++) {
            // checks if i is power of 2 
            // (length of binary number increases by +1 with every power of 2)
            if ((i & (i - 1)) == 0) len++;      
            bin = ((bin << len) | i) % mod;
        }

        return (int) bin;
    }
}