class Solution {
    public int minDeletions(String s) {
        int[] alph = new int[26];
        for(char chr: s.toCharArray()){
           ++alph[chr-'a'];
        }
        HashSet<Integer> hs = new HashSet<>();
        int sum = 0;
        for(int num:alph){
            int decree = num;
            while(decree>0&&!hs.add(decree)){
                ++sum;
                --decree;
            }
        }
        return sum;
    }
}