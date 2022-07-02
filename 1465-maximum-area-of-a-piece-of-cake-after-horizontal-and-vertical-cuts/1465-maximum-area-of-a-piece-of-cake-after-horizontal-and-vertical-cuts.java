class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long hl = getMaxDiff(horizontalCuts, h);
        long vl = getMaxDiff(verticalCuts, w);
        return (int)((hl * vl) % 1000000007);
    }
    
    private long getMaxDiff(int[] arr, int ei) {
        Arrays.sort(arr);
        int len = 0, st = 0;
        for (int i : arr) {
            len = Math.max(i - st, len);
            st = i;
        }
        len = Math.max(len, ei - st);
        return len;
    }
}