class Solution {
    public int maximumWealth(int[][] accounts) {
        int mx = 0;
        for(int i = 0; i < accounts.length; i++) {
            int curr_sum = 0;
            for(int j : accounts[i]) {
                curr_sum += j;
            }
            
            if(curr_sum > mx) {
                mx = curr_sum;
            }
        }
        
        return mx;
    }
}