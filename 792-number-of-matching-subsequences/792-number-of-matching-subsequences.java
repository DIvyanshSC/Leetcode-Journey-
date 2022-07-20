class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;

        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                if (isSubSequence(word, S, word.length(), S.length()) || word.length() == 0) {
                    result++;
                    map.put(word, true);
                } else {
                    map.put(word, false);
                }
            } else {
                if (map.get(word)) {
                    result++;
                }
            }

        }

        return result;
    }
    
    static boolean isSubSequence(String str1, String str2, int m, int n) {
        int j = 0;

        // Traverse str2 and str1, and compare
        // current character of str2 with first
        // unmatched char of str1, if matched
        // then move ahead in str1
        for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;

        // If all characters of str1 were found
        // in str2
        return (j == m);
    }
}