class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq=new HashMap<>();
        for(int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }
        
        Map<Integer, Integer> available=new HashMap<>(); //basically contains count of those subsequences that end with key-1
        
        for(int n: nums) {
            if(freq.get(n)==0) continue; //all numbers n used
            
            if(available.getOrDefault(n, 0)>0) {
                //if there exists a subsequence ending with n-1 then add current number n in it
                available.put(n, available.getOrDefault(n, 0)-1);
                //now there's array ending with n
                available.put(n+1, available.getOrDefault(n+1, 0)+1);
            }else if(freq.getOrDefault(n+1, 0)>0 & freq.getOrDefault(n+2, 0)>0) {
                //creating size of 3; subsequence at once which are consecutives
                freq.put(n+1, freq.getOrDefault(n+1, 0)-1);
                freq.put(n+2, freq.getOrDefault(n+2, 0)-1);
                available.put(n+3, available.getOrDefault(n+3, 0)+1);
            }else {
                //in this case no n+1 and n+2 are available so we'll need to create a new subsequence which will contain
                //only this n 
                //but this is not allowed in question
                //all subsequences should have size >=3
                return false;
            }
            
            freq.put(n, freq.get(n)-1);
        }
        
        return true;
    }
}