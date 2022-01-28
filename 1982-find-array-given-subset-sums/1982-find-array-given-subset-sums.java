class Solution {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int m = sums.length;
        int z = 0;

        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {

            int diff = sums[1] - sums[0];
            int a = 0, b = 0, p = m;

            for (int j = 0; j < m; ++j) {

                if (b < a && sums[b] == sums[j]) {
                    b++;
                }
                else {
                    if (z == sums[j]) {
                        p = a;
                    }

                    sums[a++] = sums[j] + diff;
                }
            }
            if (p >= m / 2) {
                ans[i] = -diff;
            }

            else {
                ans[i] = diff;
                z += diff;
            }

            m /= 2;
        }

        return ans;
    }
}