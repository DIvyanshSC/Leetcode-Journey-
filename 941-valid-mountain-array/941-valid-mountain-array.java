class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // walk up
        while (i+1 < n && arr[i] < arr[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == n-1)
            return false;

        // walk down
        while (i+1 < n && arr[i] > arr[i+1])
            i++;

        return i == n-1;
    }
}