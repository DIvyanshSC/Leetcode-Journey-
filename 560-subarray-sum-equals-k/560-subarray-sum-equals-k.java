class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
		//total sum as 0
        int sum=0;
		//frequency start point as 0,1
        map.put(0,1);
		//iterate array
        for(int i=0;i<nums.length;i++) {
			//hold usm till ith index
            sum+=nums[i];
			//if map contains sum-k. it means total no of items passed between sum and sum-k indexes has sum k.
            if(map.containsKey(sum-k)) {
			   //update counter with freq
               ans+=map.get(sum-k); 
            }
			//add sum to map as key and update frequency.
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    
}