class Solution {
    public String removeDuplicates(String s, int k) {
        
        ArrayDeque<Adjacent> st = new ArrayDeque<>(s.length());
        
        for (char c : s.toCharArray()) {
            
            if (!st.isEmpty() && st.peekLast().ch == c) {
                
                st.peekLast().freq++; // Increase the frequency
            } 
            
            else {
                st.addLast(new Adjacent(c, 1));
            }
            
            if (st.peekLast().freq == k) // If reach enough k duplicate letters -> then remove
                st.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        
        for (Adjacent a : st) {
            sb.append(String.valueOf(a.ch).repeat(a.freq));
        }
        
        return sb.toString();
    }
    
    
    class Adjacent {
        
        char ch;
        int freq;
        
        public Adjacent(char ch, int freq) {
            
            this.ch = ch;
            this.freq = freq;
        }
    }
}