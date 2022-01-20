class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = 1;
        for(int pile : piles) {
            e = Math.max(e, pile);
        }
        
        while(s < e) {
            int m = s + (e - s) / 2;
            
            int hrs = hoursSpend(piles, m);
            
            if(hrs <= h) {
                e = m;
            }
            
            else {
                s = m + 1;
            }
        }
        
        return e;
    }
    
    private int hoursSpend(int[] piles, int speed) {
        int hrSpent = 0;
        for(int pile : piles) {
            hrSpent += Math.ceil((double) pile/speed); 
        }
        
        return hrSpent;
    }
}