class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int window = p.length();
        
        for (int i = 0; i<=s.length() - window; i++) {
            
            String substr = s.substring(i, i + window);
            
            if (isAnagram(substr, p)) {
                ret.add(i);
            }
        }
        return ret;
    }

    public boolean isAnagram(String s1, String s2){
        
        int [] arr = new int[26];
        
        for (int i=0;i<s1.length();i++) {
            
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
            
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}