class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        int slen = S.length;
        int tlen = T.length;
        boolean visited[] = new boolean[T.length];
        List<Integer> res = new ArrayList<>();
        int stars = 0;
        
        while(stars < tlen){
            //There is still non-star character, continue find and replace
            boolean found = false;
            for(int i = 0; i<=tlen-slen;i++){
                //for each substring, we find a replaceable substring
                if(!visited[i] && canReplace(S, i, T)){
                    //found and to replace
                    stars = doReplace(T, i, slen, stars);
                    found = true;
                    visited[i] = true;
                    res.add(i);
                    if(stars == tlen)
                        break;
                }
            }
            if(!found)
                return new int[0];
        }
        
        //then, reverse the steps of res, assign the turns to resArray
        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resArray[i] = res.get(res.size() - i - 1);
        }
        return resArray;
    }
    //check if there is a substring that can be replace by stamp
    private boolean canReplace(char[] S, int index, char[]T){
        for(int i = 0; i < S.length; i++ ){
            if(T[i+index] != '*' && T[i+index] != S[i]){
                return false;
            }
        }
        return true;
    }
    //count the stars of current substring and return the cumulative number of stars so far.
    private int doReplace(char[]T, int index, int len, int count ){
        for(int i = 0; i < len; i++){
            if(T[i+index] != '*'){
                T[i+index] = '*';
                count++;
            }
        }
        return count;
    }
}