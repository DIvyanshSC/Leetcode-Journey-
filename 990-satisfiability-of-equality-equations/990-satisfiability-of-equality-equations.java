class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i = 0; i < 26; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(String s : equations){
            if(s.substring(1,3).equals("==")){
                union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }
        
        for(String s : equations){
            if(s.substring(1,3).equals("!=")){
               
                if(find(s.charAt(0)-'a') == find(s.charAt(3)-'a'))return false;
            }
        }
        
        return true;
    }
    private int find(int a){
        
        if(parent[a] == a){
            return a;
        }
        int temp = find(parent[a]);
        parent[a] = temp;
        return temp;
    }
    
    private void union(int a, int b){
        
        int pa  = find(a);
        int oa = find(b);
        
        if(pa != oa){
            if(rank[pa] > rank[oa]){
                parent[oa] = pa;
            }else if(rank[oa] > rank[pa]){
                parent[pa] = oa;
            }else{
                parent[oa] = pa;
                rank[pa]++;
            }
        }
    }
}