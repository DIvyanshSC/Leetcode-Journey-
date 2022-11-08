class Solution {
    public static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
    }
    public String makeGood(String s) {
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length()-1;) {
            if (s.charAt(i+1) == s.charAt(i)+32) {
                s = charRemoveAt(s, i);
                s = charRemoveAt(s, i);
                i = i - 2;
                if (i < 0) {
                    i = 0;
                }                
            }
            else if (s.charAt(i+1) == s.charAt(i)-32) {
                s = charRemoveAt(s, i);
                s = charRemoveAt(s, i);
                i = i - 2;
                if (i < 0) {
                    i = 0;
                }              
            }
            else {
                i++;
            }
        }
        return s;
    }
}