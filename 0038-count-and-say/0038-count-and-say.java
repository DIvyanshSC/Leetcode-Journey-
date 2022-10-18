class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return 1+"";
        }

        String substr = countAndSay(n-1);
        int len = substr.length();
        String ans = "";
        
        int i=0, j=i;

        while(i<len){
            int count = 0;

            while(j<len && substr.charAt(i)==substr.charAt(j)){
                count++;
                j++;
            }
            
            ans = ans + count + substr.charAt(i) + "";
            i = j; 
        }   
        return ans;
    }
}