class Solution {
    public int calculate(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        
        int ans = 0;
        char op = '+';
        int curr = 0, lastCalc = 0; // lastCalc -> the last calculated value. This approach avoids stack.
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            int num = ch - '0';
            if(Character.isDigit(ch)) {
                curr = (curr * 10) + num;
            }
            
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1) {
                if(op == '-' || op == '+') {
                    ans += lastCalc;
                    lastCalc = (op == '+') ? curr : -curr;
                }
                
                else if(op == '*') {
                    lastCalc = lastCalc * curr;
                }
                
                else if(op == '/') {
                    lastCalc = lastCalc / curr;
                }
                
                op = ch;
                curr = 0;
            }
        }
        ans += lastCalc;
        
        return ans;
        
    }
    
    
}