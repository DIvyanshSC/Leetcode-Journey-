class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        
        HashSet<Integer> map = new HashSet<>();
        HashSet<Integer> arr = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            if(!map.contains(nums1[i])) {
                map.add(nums1[i]);
            }
        }

        for(int i = 0; i < nums2.length; i++) {
            if(map.contains(nums2[i])) {
                int num = nums2[i];
                arr.add(num);
            }
        }

        int i = 0;
        int[] ans = new int[arr.size()];
        for(int val : arr) {
            ans[i++] = val;
        }

        return ans;
    }
}