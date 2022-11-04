class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowel = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                vowel.append(ch);
            }
        }
        String str = vowel.reverse().toString();
        int j = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                result.append(str.charAt(j));
                j++;
            }
            else
                result.append(ch);
        }

        return result.toString();
    }
}