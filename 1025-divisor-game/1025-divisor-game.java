class Solution {
    public boolean divisorGame(int n) {
        int mem[]=new int [n+1];
        Arrays.fill(mem,-1);
        return helper(n,mem);
    }
    
    boolean helper(int n, int mem[]){
        if(n<=1) return false;
        
        if(mem[n]!=-1){
            if(mem[n]==0) return false;
            else return true;
        }
        
        for(int x=1;x<n;x++){
            if(n%x==0){
                if(!helper(n-x,mem)){
                    mem[n]=1;
                    return true;
                }
            }
        }
        mem[n]=0;
        return false;
    }
}