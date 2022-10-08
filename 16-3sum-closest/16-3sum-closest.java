class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i < nums.length; i++){
            int start = i+1;
            int end = nums.length-1;
            while(start < end){
                sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum - target) < Math.abs(target - res)){
                    res = sum;
                }else if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }  
        }
        return res;
    }
}