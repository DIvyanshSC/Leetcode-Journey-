class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toUpperCase();
        int alike=0;

        for(int i=0, j=s.length()/2;j<s.length();i++,j++){

            if("AEIOU".indexOf(s.charAt(i))>=0) alike++;

            if("AEIOU".indexOf(s.charAt(j))>=0) alike--;
        }


        return alike==0;
    }
}