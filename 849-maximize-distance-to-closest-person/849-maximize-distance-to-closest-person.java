class Solution {
    public int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length == 0) return -1;
        int left = -1, right = -1;
        int len = seats.length;
        int dist = 0;

        int i = 0;
        while(i < len) {
            // while 1 
            while (i < len && seats[i] == 1) {
                i++;
            }
            left = i;
            //while 0
            while(i < len && seats[i] == 0) {
                i++;
            }
            right = i;
            // if start index 0 or end last,dist is (right - left)
            // or dist is Math.ceil((right - left) / 2.0)
            if(left == 0 || right == len) {
                dist = Math.max(right - left, dist);
            } else {
                dist = Math.max((int) Math.ceil((right - left) / 2.0), dist);
            }
        }
        return dist;
    }
}