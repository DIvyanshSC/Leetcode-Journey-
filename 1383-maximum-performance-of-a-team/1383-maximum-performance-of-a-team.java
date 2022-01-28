class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD = 1000000000 + 7;

        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        Arrays.sort(engineers, (engineer1, engineer2) -> engineer2[1] - engineer1[1]);

        long speedSum = 0;
        long maximumPerformance = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] engineer : engineers) {
            if (minHeap.size() == k) {
                speedSum -= minHeap.poll();
            }

            speedSum += engineer[0];
            minHeap.offer (engineer[0]);
            maximumPerformance = Math.max(maximumPerformance, speedSum * engineer[1]);
        }

        return (int) (maximumPerformance % MOD);
    }
}