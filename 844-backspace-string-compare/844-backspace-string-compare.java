class Solution {
    public boolean backspaceCompare(String s, String t) {
        /**
            Time Complexity: O(M + N)
            Space Complexity: O(1)
        */
        
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (s.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (t.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        
        return true;
        
//         String s1 = stackUse(s);
//         String s2 = stackUse(t);
        
//         if(s1.equals(s2)) return true;
        
//         else return false;
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