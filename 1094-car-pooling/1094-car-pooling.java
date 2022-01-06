class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int count[] = new int[1001];
        for(int t[] : trips)
            
            for(int i = t[1]; i < t[2]; i++){
                
                count[i] += t[0];
                
                if(count[i] > capacity) {
                    return false;
                }
                
            }
        
        return true; 
    }
}