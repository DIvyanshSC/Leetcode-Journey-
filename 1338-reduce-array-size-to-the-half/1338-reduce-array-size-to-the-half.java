class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : map.values()) queue.offer(i);
        int ans = 0, len = arr.length, count= 0;
        while(!queue.isEmpty()) {
            count++;
            Integer poll = queue.poll();
            ans  += poll;
            if (ans >= len/2) return count;
        }
        return 0;
    }
}