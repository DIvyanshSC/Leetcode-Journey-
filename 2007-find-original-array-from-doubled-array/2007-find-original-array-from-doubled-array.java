class Solution {
    private static final int[] empty = new int[0];

    public int[] findOriginalArray(int[] changed) {

        if (changed.length % 2 != 0) return empty;

        final Map<Integer, Integer> counters = new HashMap<>(changed.length);
        for (int num : changed) counters.compute(num, (k, v) -> v == null ? 1 : v + 1);

        Arrays.sort(changed);
        int[] original = new int[changed.length >> 1];

        int i = 0;
        for (int num : changed) {

            if (counters.get(num) == 0) continue;

            int doubleNum = num << 1;
            var b = counters.get(doubleNum);
            if (b == null || b <= 0) return empty;

            original[i++] = num;

            counters.computeIfPresent(num, (k, v) -> v - 1);
            counters.computeIfPresent(doubleNum, (k, v) -> v - 1);
        }

        return original;
    }
}