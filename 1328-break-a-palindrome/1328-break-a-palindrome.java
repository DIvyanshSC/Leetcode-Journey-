class Solution {
    public String breakPalindrome(String palindrome) {
        String str = palindrome;
        if(str.length()==1){
            return "";
        }

        char s[] = str.toCharArray();
        int n = s.length;

        if(s[0]!='a'){
            s[0] = 'a';
        }
        else{
            int i=0;
            while(i< n && s[i]=='a') i++;

            if(i==n/2 && n%2==1 && s[n/2-1]=='a'){
                s[n-1]='b';
            }
            else if(i==n){
                s[n-1]='b';
            }else{
                s[i]='a';
            }
        }

        return String.valueOf(s);
    }
}