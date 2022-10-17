class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        dp=new Integer[d+1][jobDifficulty.length];
        int ret=util(jobDifficulty, d-1, 0);
        return ret==Integer.MAX_VALUE?-1:ret;
    }
    
    private Integer dp[][];
    
    private int util(int arr[], int d, int i) {
        if(dp[d][i]!=null) return dp[d][i];
        
        if(d==0) {
            return dp[d][i]=findMax(arr, i, arr.length-1);
        }
        
        int ans=Integer.MAX_VALUE;
        //breaking the remaing array(i to arr.length-1) after 'itr' th index 
        for(int itr=i;itr<arr.length-1;itr++) {
            int max=findMax(arr, i, itr);
            int ret=util(arr, d-1, itr+1);
            if(ret==Integer.MAX_VALUE)
                ans=Math.min(ans, Integer.MAX_VALUE);
            else
                ans=Math.min(ans, max+ret);
        }
        return dp[d][i]=ans;
    }
    
    private int findMax(int arr[], int i, int j) {
        int max=Integer.MIN_VALUE;
        for(int itr=i;itr<=j;itr++) {
            max=Math.max(max, arr[itr]);
        }
        return max;
    }
}