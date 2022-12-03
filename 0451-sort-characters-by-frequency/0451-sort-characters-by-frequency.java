class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0)+1);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        Collections.sort(list, (a,b)->b.getValue()-a.getValue());
        StringBuffer ans = new StringBuffer("");
        for(Map.Entry<Character, Integer> e: list) {
            for(int i=0;i<e.getValue();i++) ans.append(e.getKey());
        }
        return ans.toString();
    }
}