class Solution {
    public char findTheDifference(String s, String t) {
        if(s.isEmpty()) {
            return t.charAt(0);
        }
        
        
        char c = 0;
        for(char cs : s.toCharArray()) {
            c ^= cs;
        }
        
        for(char ct : t.toCharArray()) {
            c ^= ct;
        }
        
        return c;
    }
    
}