public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while(n != 0) {
            /**
                int temp = n%2;
                if(temp == 1) count++;

                n /= 2;
            */
            
            // bit manipulation - n & n-1 removes one bit
            n = n & (n-1);
            count++;
            
        }
        
        return count;
    }
}