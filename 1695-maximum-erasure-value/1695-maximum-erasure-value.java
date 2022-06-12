class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        // BETTER LINEAR TIME APPROACH
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];

        int maxScore = 0;
        for (int l=0, r=0; r<nums.length; r++) {
            prefixSum[r+1] = prefixSum[r] + nums[r];
            if (lastIndex.containsKey(nums[r])) 
                l = Math.max(l, lastIndex.get(nums[r]) + 1);
            maxScore = Math.max(maxScore, prefixSum[r+1] - prefixSum[l]);
            lastIndex.put(nums[r], r);
        }

        return maxScore;
        
        // BAD LINEAR TIME APPROACH BUT USES LESS SPACE
        
        /**
        int maxScore = 0;
        int currScore = 0;
        Set<Integer> set = new HashSet<>();

        for (int l=0, r=0; r<nums.length; r++) {
            
            while (!set.add(nums[r])) { // expanding a right pointer while keeping track of the sum until we reach a value we've seen before
                
                // increment our left pointer until the duplicate no longer exists
                currScore -= nums[l];
                set.remove(nums[l++]);
            }
            
            currScore += nums[r];
            maxScore = Math.max(maxScore, currScore);
        }

        return maxScore;
        */
        
    }
}