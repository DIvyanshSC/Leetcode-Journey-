class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int ttest = minutesToTest, tdie = minutesToDie;
        
        int test = ttest/tdie;
        int i=0;
        while(Math.pow(test+1,i)< buckets){
            i++;
        }
        return i;
    }
}