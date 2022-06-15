class Solution {
    
    
    private Set<String> wordDict;
    private Map<String, Integer> memo;

    public int longestStrChain(String[] words) {
        wordDict = new HashSet<>();
        Collections.addAll(wordDict, words); // adding all words to a set for constant look-up

        int maxPath = 1;
        memo = new HashMap<>();
        for (String word: words) 
            maxPath = Math.max(maxPath, dfs(word));

        return maxPath;
    }

    private int dfs(String word) {
        if (memo.containsKey(word)) return memo.get(word); // if we're computed this word before, return the result.

        StringBuilder sb = new StringBuilder(word);
        int maxPath = 0;
        // delete each character, check if that's a valid word in the set, add the character back and continue
        for (int i=0; i<word.length(); i++) {
            sb.deleteCharAt(i);
            String prevWord = sb.toString();
            if (wordDict.contains(prevWord)) 
                maxPath = Math.max(maxPath, dfs(prevWord));
            sb.insert(i, word.charAt(i));
        }

        memo.put(word, maxPath + 1); // store the result
        return memo.get(word);
    }
}