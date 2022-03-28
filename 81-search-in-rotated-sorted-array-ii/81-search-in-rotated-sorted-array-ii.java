class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        
        if(pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target) != -1 ? true : false;
        }
        
        if(nums[pivot] == target) {
            return true;
        }
        
        if(target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target) != -1 ? true : false;
        }
        
        return binarySearch(nums, pivot + 1, nums.length - 1, target) != -1 ? true : false; 
    }
    
    private int binarySearch(int[] nums, int s, int e, int target) {
        while(s <= e) {

            int m = s + (e - s) / 2;
            if(nums[m] > target) {
                e = m - 1;
            }

            else if(nums[m] < target) {
                s = m + 1;
            }

            else {
                return m;
            }
        }

        return -1;
    }
    
    private int findPivot(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while(s < e) {
            int m = s + ( e - s) / 2;
            //Case 1
            if((m < e) && (nums[m] > nums [m + 1])) {
                return m;
            }
            //Case 2
            if((m > s) && (nums[m] < nums[m - 1])) {
                return m - 1;
            }

            //if elements at middle, start & end are equal, then just skip duplicates
            if(nums[m] == nums[s] && nums[m] == nums[e]) {

                // check if start is pivot, return s as that will be pivot if this condition is true
                if( s < e && nums[s] > nums[s + 1]) {
                    return s;
                }
                s++;

                // check if end is pivot, return e - 1 as that will be pivot if this condition is true
                if( e > s && nums[e] < nums[e - 1]) {
                    return e - 1;
                }
                e--;
            }

            // left side is sorted, so pivot should be in right
            else if((nums[s] < nums[m]) || (nums[s] == nums[m] && nums[e] < nums[m])) {
                s = m + 1;
            }

            else {
                e = m - 1;
            }
        }

        return -1;
    }
}