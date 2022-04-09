class Solution {
    public int[] topKFrequent(int[] A, int k) {
         // TC: O(n), SC: O(n)
         // using bucket sort
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) map.put(num, map.getOrDefault(num, 0) + 1);

        int n = A.length;
        List<Integer>[] buckets = new List[n];

        map.forEach((num, freq) -> {
            int index = n - freq;
            if (buckets[index] == null) buckets[index] = new ArrayList<>();
            buckets[index].add(num);
        });

        int i = 0, res[] = new int[k];

        for (List<Integer> bucket : buckets) {
            if (bucket == null) continue;

            for (int num : bucket) {
                res[i++] = num;
                if (i == k) return res;
            }
        }

        return res;
    }
}