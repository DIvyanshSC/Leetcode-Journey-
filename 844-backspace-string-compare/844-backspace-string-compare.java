class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = stackUse(s);
        String s2 = stackUse(t);
        
        if(s1.equals(s2)) return true;
        
        else return false;
    }
    
    private static String stackUse(String s) {
        int n = s.length();
        int i = 0;
        
        Stack<Character> st = new Stack<>();
        
        while(i < n) {
            
            if(s.charAt(i) != '#') {
                st.push(s.charAt(i));
            }
            
            else {
                if(!st.isEmpty()) {
                    st.pop();
                }
            }
            
            i++;
        }
        
        // System.out.println(st.toString());
        return st.toString();
    }
    
}