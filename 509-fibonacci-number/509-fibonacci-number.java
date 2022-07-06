class Solution {
    public int fib(int n) {
        return f(n);
    }
    
    private static int f(int N) {
        if (N <= 1) {
            return N;            
        }

        // initialize base case variables
        int a = 0, b = 1;
        int sum = 0;

        while (N > 1) {
            // calculate next value as the sum of previous two values
            sum = a + b;

            // switch all values to the next value in the series
            a = b;
            b = sum;

            // decrement counter
            N -= 1;
        }

        return sum;
    }
}