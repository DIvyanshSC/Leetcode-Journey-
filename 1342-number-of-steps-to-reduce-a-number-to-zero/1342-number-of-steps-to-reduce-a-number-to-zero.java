class Solution {
    public int numberOfSteps(int num) {
//         int step = 0;

//         while(num != 0) {
//             if (num % 2 == 0) {
//                 num /= 2;
//             }

//             else {
//                 num = num - 1;
//             }

//             ++step;
//         }
//         return step;
        
        return helper(num, 0);
    }
    
    private int helper(int n, int step) {
        if(n == 0) {
            return step;
        }
        
        if(n % 2 == 0) {
            return helper(n/2, step + 1);
        }
        
        return helper(n -= 1, step + 1);
    }
}