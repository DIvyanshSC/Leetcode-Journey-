class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Double>[] adjs = buildGraph(edges, succProb, n);

        double[] distTo = new double[n];
        Arrays.fill(distTo, Double.MAX_VALUE);
        distTo[start] = 0;

        ValueOrderedTreeMap<Integer, Double> cusTreeMap = new ValueOrderedTreeMap<>();
        cusTreeMap.put(start, distTo[start]);

        while (!cusTreeMap.isEmpty()) {
            int v = cusTreeMap.pollFirstKey();
            if (v == end) {
                break;
            }

            adjs[v].forEach((w, weight) -> {
                if (distTo[w] > distTo[v] + weight) {
                    distTo[w] = distTo[v] + weight;
                    cusTreeMap.put(w, distTo[w]);
                }
            });
        }

        return distTo[end] == Double.MAX_VALUE ? 0 : Math.pow(10, -distTo[end]);
    }
    
    public static Map<Integer, Double> [] buildGraph(int[][] edges, double[] succProb, int n) {
        Map<Integer, Double>[] adjList = new Map[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new HashMap<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            double weight = -Math.log10(prob);
            adjList[u].put(v, weight);
            adjList[v].put(u, weight);
        }
        return adjList;
    }
    
    class ValueOrderedTreeMap<K extends Comparable<K>, V extends Comparable<V>> {
        private final Map<K, V> map = new HashMap<>();
        private final TreeSet<K> set = new TreeSet<> (
                Comparator.<K, V>comparing(map::get).thenComparing(Function.identity())
        );

        public void put(K key, V val) {
            if (map.containsKey(key)) {
                set.remove(key);
            }
            map.put(key, val);
            set.add(key);
        }
        public boolean isEmpty() {
            return map.isEmpty();
        }

        public K pollFirstKey() {
            if (isEmpty()) {
                return null;
            }
            K res = set.pollFirst();
            map.remove(res);
            return res;
        }
    }
}